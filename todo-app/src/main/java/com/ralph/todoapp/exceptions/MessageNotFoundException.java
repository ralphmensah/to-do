package com.ralph.todoapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageNotFoundException extends IllegalAccessException {
    public MessageNotFoundException(String message_not_found) {
        super(message_not_found);
    }

}
