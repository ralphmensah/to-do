package com.ralph.todoapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends IllegalAccessException{

        public UserNotFoundException (String message_not_found) {
            super(message_not_found);
        }

}
