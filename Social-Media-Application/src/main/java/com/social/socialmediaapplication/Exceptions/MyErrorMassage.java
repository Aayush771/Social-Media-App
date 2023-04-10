package com.social.socialmediaapplication.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyErrorMassage {
    private LocalDateTime localDateTime;

    private String message;

    private String detailString;
}
