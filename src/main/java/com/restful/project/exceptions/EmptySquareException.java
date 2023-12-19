package com.restful.project.exceptions;

public class EmptySquareException extends IllegalArgumentException {
    public EmptySquareException(String message) {
        super(message);
    }
}