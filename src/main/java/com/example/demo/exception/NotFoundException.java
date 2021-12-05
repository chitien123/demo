package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{
    String message;
    HttpStatus status;

    public NotFoundException(String message, HttpStatus status) {
        this.message=message;
        this.status = status;
    }
}
