package com.social.socialmediaapplication.Serivce;

import com.social.socialmediaapplication.Entity.User;

import java.util.List;

public interface UserService {
    public void createUser(User user);
    public User getUserById(Integer id);
    public User updateUser(Integer userId, String name, String bio);
    public void deleteUser(Integer userId);
    public Long getTotalNumberOfUsers();
    public List<User> getTopActiveUsers();
}
