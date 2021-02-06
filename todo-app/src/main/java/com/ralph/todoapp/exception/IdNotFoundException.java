package com.ralph.todoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNotFoundException extends NumberFormatException{
    public IdNotFoundException(String format) {
        super(format);
    }
}
