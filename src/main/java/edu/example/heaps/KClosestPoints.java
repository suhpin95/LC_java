package edu.example.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPoints {
    Queue<int[] > maxHeap = new PriorityQueue<>((a,b) -> getDistance(b) - getDistance(a) );

    public int[][] kClosest(int[][] points, int k) {
        for(int[] point: points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}


