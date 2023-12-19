package com.restful.project.exceptions.minesweeper;

public class InvalidSquareException extends IllegalArgumentException {
    public InvalidSquareException(String message) {
        super(message);
    }
}