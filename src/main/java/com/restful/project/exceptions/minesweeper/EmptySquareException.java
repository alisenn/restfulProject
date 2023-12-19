package com.restful.project.exceptions.minesweeper;

public class EmptySquareException extends IllegalArgumentException {
    public EmptySquareException(String message) {
        super(message);
    }
}