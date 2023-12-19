package com.restful.project.service;

import java.util.EmptyStackException;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.restful.project.exceptions.rpnCalculator.DivisionByZeroException;
import com.restful.project.exceptions.rpnCalculator.EmptyExpressionException;
import com.restful.project.exceptions.rpnCalculator.InsufficientOperandsException;
import com.restful.project.exceptions.rpnCalculator.InvalidTokenException;
@Service
public class RpnService {

    public double calculate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new EmptyExpressionException("Expression cannot be null or empty");
        }

        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            try {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        double subtrahend = stack.pop();
                        double minuend = stack.pop();
                        stack.push(minuend - subtrahend);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        double divisor = stack.pop();
                        if (divisor == 0) {
                            throw new DivisionByZeroException("Division by zero");
                        }
                        double dividend = stack.pop();
                        stack.push(dividend / divisor);
                        break;
                    default:
                        stack.push(Double.valueOf(token));
                }
            } catch (NumberFormatException e) {
                throw new InvalidTokenException("Invalid token in expression: " + token);
            } catch (EmptyStackException e) {
                throw new InsufficientOperandsException("Not enough operands in expression for operator: " + token);
            }
        }
        
        if (stack.size() != 1) {
            throw new InsufficientOperandsException("Invalid expression: more than one number left in the stack");
        }

        return stack.pop();
    }
}