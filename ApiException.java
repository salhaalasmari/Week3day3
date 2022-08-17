package com.example.week2day4.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
