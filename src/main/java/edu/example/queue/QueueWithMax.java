package edu.example.queue;

import java.util.Deque;

public class QueueWithMax {
    Deque<Integer> maxQueue;
    Deque<Integer> mainQueue;
    public QueueWithMax() {}
    public void add(int val){
        while (!maxQueue.isEmpty() && val > maxQueue.peekLast()){
            maxQueue.removeLast();
        }
        maxQueue.addLast(val);
        mainQueue.addLast(val);
    }
    public void remove(){
        if(mainQueue.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        int val = mainQueue.removeLast();
        if(val == maxQueue.peekLast()){
            maxQueue.removeLast();
        }
    }
    public int getMax(){
        if(maxQueue.isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return maxQueue.getFirst();
    }
}
