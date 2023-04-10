package com.social.socialmediaapplication.Serivce;

import com.social.socialmediaapplication.Entity.Post;

import java.util.List;

public interface PostService {
    public void createPost(Post post);
    public Post getPostById(Integer postId);
    public void deletePost(Integer postId);
    public Post updatePost(Integer postId, String content);
    public void likePost(Integer postId);
    public void unlikePost(Integer postId);
    public Long getTotalNumberOfPosts();
    public List<Post> getTopLikedPosts();
}
