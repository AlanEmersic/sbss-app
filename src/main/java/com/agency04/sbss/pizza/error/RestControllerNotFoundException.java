package com.agency04.sbss.pizza.error;

public class RestControllerNotFoundException extends RuntimeException{
    public RestControllerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestControllerNotFoundException(Throwable cause) {
        super(cause);
    }

    public RestControllerNotFoundException(String message) {
        super(message);
    }
}
