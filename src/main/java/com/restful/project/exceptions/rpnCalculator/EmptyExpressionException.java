package com.restful.project.exceptions.rpnCalculator;

public class EmptyExpressionException extends IllegalArgumentException {
    public EmptyExpressionException(String message) {
        super(message);
    }
}