package com.agency04.sbss.pizza.error;

public class PizzeriaNotFoundException extends RuntimeException{
    public PizzeriaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PizzeriaNotFoundException(Throwable cause) {
        super(cause);
    }

    public PizzeriaNotFoundException(String message) {
        super(message);
    }
}
