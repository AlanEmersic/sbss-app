package com.agency04.sbss.pizza.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PizzeriaExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PizzeriaErrorResponse> handleException(PizzeriaNotFoundException ex) {
        PizzeriaErrorResponse error = new PizzeriaErrorResponse();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PizzeriaErrorResponse> handleException(Exception ex) {
        PizzeriaErrorResponse error = new PizzeriaErrorResponse();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
