package edu.example.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElement {

    private Queue<Integer> minHeap;
    int kthElement;
    public KLargestElement(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.kthElement = k;
        for(int num : nums){
            minHeap.offer(num);
        }
        while(minHeap.size() > k){
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > this.kthElement){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
