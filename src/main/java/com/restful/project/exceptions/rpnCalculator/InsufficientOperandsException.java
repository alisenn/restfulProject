package com.restful.project.exceptions.rpnCalculator;

public class InsufficientOperandsException extends IllegalArgumentException {
    public InsufficientOperandsException(String message) {
        super(message);
    }
}