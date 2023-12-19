package com.restful.project.exceptions.minesweeper;

public class NullSquareException extends IllegalArgumentException {
    public NullSquareException(String message) {
        super(message);
    }
}

