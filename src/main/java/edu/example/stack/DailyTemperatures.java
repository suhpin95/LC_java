package edu.example.stack;

import java.util.Stack;

public class DailyTemperatures {
    Stack<Integer> stack;
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0){
            return null;
        }
        stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && stack.peek() < temperatures[i]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
