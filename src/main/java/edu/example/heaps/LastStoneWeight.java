package edu.example.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    private Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

    public int lastStoneWeight(int[] stones) {
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if(stone1 != stone2){
                maxHeap.offer(Math.abs(stone1 - stone2));
            }
        }
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }
}
