package com.restful.project.exceptions.rpnCalculator;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}