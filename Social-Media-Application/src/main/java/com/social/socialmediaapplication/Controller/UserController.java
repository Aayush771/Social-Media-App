package com.social.socialmediaapplication.Controller;

import com.social.socialmediaapplication.Entity.User;
import com.social.socialmediaapplication.Serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResponseEntity saveUserHandler(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserHandler(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/user/{id}/name/bio")
    public ResponseEntity<User> getUserHandler(@PathVariable("id") Integer id,
                                               @RequestParam String name,@RequestParam String bio){
        User user = userService.updateUser(id,name,bio);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping ("/user/{id}")
    public ResponseEntity DeleteUserHandler(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/analytics/users")
    public ResponseEntity<Long> getUserCountHandler(){
        Long count = userService.getTotalNumberOfUsers();
        return new ResponseEntity<>(count,HttpStatus.ACCEPTED);
    }
    @GetMapping("/analytics/users/top-active")
    public ResponseEntity<List<User>> getTopUsersHandler(){
        List<User> users = userService.getTopActiveUsers();
        return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }
}
