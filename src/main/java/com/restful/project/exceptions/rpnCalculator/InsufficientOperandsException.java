package com.restful.project.exceptions.rpnCalculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientOperandsException extends IllegalArgumentException {
    public InsufficientOperandsException(String message) {
        super(message);
    }
}