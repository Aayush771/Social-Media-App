package com.social.socialmediaapplication.Repository;

import com.social.socialmediaapplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
