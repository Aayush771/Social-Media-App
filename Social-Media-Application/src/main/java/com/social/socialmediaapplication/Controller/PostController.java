package com.social.socialmediaapplication.Controller;

import com.social.socialmediaapplication.Entity.Post;
import com.social.socialmediaapplication.Serivce.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/posts")
    public ResponseEntity savePostHandler(@RequestBody Post post){
         postService.createPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostHandler(@PathVariable("id") Integer id){
         Post post = postService.getPostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @PutMapping("/posts/{id}/content")
    public ResponseEntity<Post> getUserHandler(@PathVariable("id") Integer id,
                                               @RequestParam String content){
        Post post = postService.updatePost(id,content);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @DeleteMapping ("/posts/{id}")
    public ResponseEntity DeleteUserHandler(@PathVariable("id") Integer id){
         postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping(" /posts/{id}/like")
    public ResponseEntity likePostHandler(@PathVariable("id") Integer id){
        postService.likePost(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PostMapping(" /posts/{id}/unlike")
    public ResponseEntity unLikePostHandler(@PathVariable("id") Integer id){
        postService.unlikePost(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/analytics/posts")
    public ResponseEntity<Long> getPostCountHandler(){
        Long count = postService.getTotalNumberOfPosts();
        return new ResponseEntity<>(count,HttpStatus.ACCEPTED);
    }
    @GetMapping("/analytics/users/top-liked")
    public ResponseEntity<List<Post>> getTopUsersHandler(){
        List<Post> posts = postService.getTopLikedPosts();
        return new ResponseEntity<>(posts,HttpStatus.ACCEPTED);
    }
}
