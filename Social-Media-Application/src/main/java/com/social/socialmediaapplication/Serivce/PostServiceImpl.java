package com.social.socialmediaapplication.Serivce;

import com.social.socialmediaapplication.Entity.Post;
import com.social.socialmediaapplication.Entity.User;
import com.social.socialmediaapplication.Exceptions.PostNotFoundException;
import com.social.socialmediaapplication.Exceptions.UserNotFound;
import com.social.socialmediaapplication.Repository.PostRepository;
import com.social.socialmediaapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;


    public void createPost(Post post) {
      User user = userRepository.findById(post.getUserId()).orElseThrow(() -> new UserNotFound("User not found with this "+post.getUserId()));
       List<Post> posts = user.getPosts();
        if(posts.size() == 0){
           List<Post> posts1 = new ArrayList<>();
            posts1.add(post);
            user.setPosts(posts1);
        }else{
            posts.add(post);
            user.setPosts(posts);

        }
         userRepository.save(user);
        postRepository.save(post);
    }

    public Post getPostById(Integer postId) {
        return postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post not found"));
    }

    public Post updatePost(Integer postId, String content) {
        Post post = getPostById(postId);
        post.setContent(content);
        return postRepository.save(post);
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }

    public void likePost(Integer postId) {
        Post post = getPostById(postId);
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
    }

    public void unlikePost(Integer postId) {
        Post post = getPostById(postId);
        post.setLikes(Math.max(post.getLikes() - 1, 0));
        postRepository.save(post);
    }

    public Long getTotalNumberOfPosts() {
        return postRepository.count();
    }

    public List<Post> getTopLikedPosts() {
        return postRepository.findAllByOrderByLikesDesc().stream().limit(5).collect(Collectors.toList());
    }
}
