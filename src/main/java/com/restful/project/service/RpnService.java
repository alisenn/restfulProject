package com.restful.project.service;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class RpnService {

    public double calculate(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
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
                    double dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                default:
                    stack.push(Double.valueOf(token));
            }
        }
        
        return stack.pop();
    }
}
