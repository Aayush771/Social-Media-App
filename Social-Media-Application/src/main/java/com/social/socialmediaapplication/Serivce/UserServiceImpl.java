package com.social.socialmediaapplication.Serivce;

import com.social.socialmediaapplication.Entity.User;
import com.social.socialmediaapplication.Exceptions.UserNotFound;
import com.social.socialmediaapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    public void createUser(User user) {
         userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFound("User not found with this userId "+id));
    }

    public User updateUser(Integer userId, String name, String bio) {
        User user = getUserById(userId);
        if(name!=null){
            user.setName(name);
        }
        if(bio!=null){
            user.setBio(bio);
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public Long getTotalNumberOfUsers() {
        return userRepository.count();
    }

    public List<User> getTopActiveUsers() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("posts.size").descending());
        return userRepository.findAll(pageable).getContent();
    }
}

