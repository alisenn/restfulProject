package com.restful.project.exceptions.minesweeper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptySquareException extends IllegalArgumentException {
    public EmptySquareException(String message) {
        super(message);
    }
}