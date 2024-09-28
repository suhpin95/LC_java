package edu.example.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowQueue {
    public List<Integer> getSum(int[] arr, int windowSize) {
        if(arr.length == 0 || windowSize <= 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int sum = 0;
        for (int val : arr) {
            if (deque.size() == windowSize) {
                sum -= deque.poll();
            }
            deque.add(val);
            sum += val;
            if (deque.size() == windowSize) {
                result.add(sum);
            }
        }
        return result;
    }
}
