package com.social.socialmediaapplication.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<MyErrorMassage> handleCustomerPasswordException(UserNotFound unf, WebRequest req){

        MyErrorMassage message = new MyErrorMassage(LocalDateTime.now(),unf.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorMassage>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<MyErrorMassage> handleCustomerPasswordException(PostNotFoundException pnf, WebRequest req){

        MyErrorMassage message = new MyErrorMassage(LocalDateTime.now(),pnf.getMessage(),req.getDescription(false));

        return new ResponseEntity<MyErrorMassage>(message, HttpStatus.BAD_REQUEST);
    }
}
