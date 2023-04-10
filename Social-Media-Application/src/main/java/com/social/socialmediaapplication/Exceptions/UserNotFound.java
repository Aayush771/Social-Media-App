package com.social.socialmediaapplication.Exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String msg){
        super(msg);
    }
}
