package edu.example.stack;

import java.util.Stack;

public class MaxStack {
//    Stack<Pair<Integer, Integer>> stack = new Stack<>();
//
//    public void push(int val){
//        if(stack.isEmpty()){
//            stack.push(new Pair<>(val, val));
//        }
//        int maxVal = stack.peek().getValue();
//        maxVal = Math.max(val, maxVal);
//        stack.push(new Pair<>(val, maxVal));
//    }
//    public int getMax(){
//        if(stack.isEmpty()){
//            return -1;
//        }
//        Pair<Integer, Integer> top = stack.pop();
//        return top.getValue();
//    }

    Stack<Integer> maxValStack;
    Stack<Integer> stack;
    public void push(int val) {
        
    }
}
class Pair<K,V>{
    K key;
    V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


