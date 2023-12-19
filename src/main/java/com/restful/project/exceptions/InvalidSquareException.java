package com.restful.project.exceptions;

public class InvalidSquareException extends IllegalArgumentException {
    public InvalidSquareException(String message) {
        super(message);
    }
}