package edu.example.stack;

import java.util.Stack;

public class MinStack {
    private Stack<KeyValue<Integer, Integer>> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new KeyValue<>(val, val));
        } else{
            int minVal = stack.peek().value();
            minVal = Math.min(val, minVal);
            stack.push(new KeyValue<>(val, minVal));
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek().key();
    }

    public int getMin() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek().value();
    }


}
record KeyValue<Key, Value>(Key key, Value value) {}
