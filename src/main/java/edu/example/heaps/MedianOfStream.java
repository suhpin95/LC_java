package edu.example.heaps;

import java.util.PriorityQueue;

public class MedianOfStream {
    private PriorityQueue<Integer> firstHalf;
    private PriorityQueue<Integer> secondHalf;

    public MedianOfStream() {
        //maxheap
        firstHalf = new PriorityQueue<>();
        //minHeap
        secondHalf = new PriorityQueue<>((a,b) -> b-a);
    }

    public double findMedian() {
        if(firstHalf.isEmpty() && secondHalf.isEmpty()){
            return -1;
        }
        if(firstHalf.size() == secondHalf.size()){
            return (firstHalf.peek() + secondHalf.peek()) / 2;
        }
        return secondHalf.peek();
    }

    public void addNum(int num) {
        if(secondHalf.isEmpty()){
            secondHalf.add(num);
            return;
        }
        if(secondHalf.size() == firstHalf.size()){
            if(num < firstHalf.peek()){
                secondHalf.add(firstHalf.poll());
                firstHalf.add(num);
            } else{
                secondHalf.add(num);
            }
        } else{
            if(num > secondHalf.peek()){
                firstHalf.add(secondHalf.poll());
                secondHalf.add(num);
            } else{
                firstHalf.add(num);
            }
        }
    }

}
