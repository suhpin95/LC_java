package edu.example.heaps;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class KthLargestElementII {
    Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
    public int findKthLargest(int[] nums, int k) {
        IntStream.range(0, nums.length).forEach(i -> maxHeap.offer(nums[i]));
        while (maxHeap.size() > k) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
