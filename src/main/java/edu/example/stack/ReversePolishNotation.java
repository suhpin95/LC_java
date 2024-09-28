package edu.example.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {
    Stack<Integer> stack = new Stack<>();
    Set<String> operators = new HashSet<>();
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length <= 1 ) {
            return Integer.parseInt(tokens[0]);
        }
        init();

        for(String token : tokens) {
            if(operators.contains(token)) {
                performOperation(token);
            } else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private void init() {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
    }
    private void performOperation(String token) {
        if(stack.isEmpty()) {
            return;
        }
        int num1 = stack.pop();
        int num2 = stack.pop();
        switch (token) {
            case "+": stack.push(num1 + num2);
            break;

            case "-": stack.push(num1 - num2);
            break;
            case "*":stack.push( num1 * num2);
            break;
            case "/":stack.push( num1 / num2);
            break;
        };
    }
}
