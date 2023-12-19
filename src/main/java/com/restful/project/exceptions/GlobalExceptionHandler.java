package com.restful.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.restful.project.exceptions.minesweeper.EmptySquareException;
import com.restful.project.exceptions.minesweeper.InvalidSquareException;
import com.restful.project.exceptions.minesweeper.NullSquareException;
import com.restful.project.exceptions.rpnCalculator.DivisionByZeroException;
import com.restful.project.exceptions.rpnCalculator.EmptyExpressionException;
import com.restful.project.exceptions.rpnCalculator.InsufficientOperandsException;
import com.restful.project.exceptions.rpnCalculator.InvalidTokenException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmptyExpressionException.class)
    public ResponseEntity<String> handleEmptyExpressionException(EmptyExpressionException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<String> handleInvalidTokenException(InvalidTokenException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InsufficientOperandsException.class)
    public ResponseEntity<String> handleInsufficientOperandsException(InsufficientOperandsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<String> handleDivisionByZeroException(DivisionByZeroException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptySquareException.class)
    public ResponseEntity<String> handleEmptySquareException(EmptySquareException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidSquareException.class)
    public ResponseEntity<String> handleInvalidSquareException(InvalidSquareException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullSquareException.class)
    public ResponseEntity<String> handleNullSquareException(NullSquareException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    
}