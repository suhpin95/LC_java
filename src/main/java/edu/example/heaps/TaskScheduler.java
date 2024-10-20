package edu.example.heaps;

import java.util.*;

public class TaskScheduler {
    Map<Character, Integer> cache = new HashMap<>();
    Queue<Character> maxHeap = new PriorityQueue<>((a,b) -> cache.get(b) - cache.get(a));

    public int leastInterval(char[] tasks, int n) {
        for(char task: tasks){
            cache.put(task, cache.getOrDefault(task, 0) + 1);
        }
        for(char key : cache.keySet()){
            maxHeap.add(key);
        }
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            char task;
            if(!maxHeap.isEmpty()){
                task = maxHeap.poll();
                int val = cache.get(task) - 1;
                cache.put(task, val);
                if(val > 0){
                    queue.add(new Pair(task, time + n));
                }
            }
            // check if the current time == the time present in the queue for a particular task
            if(!queue.isEmpty() && time == queue.peek().time){
                maxHeap.add(queue.poll().task);
            }
        }
        return time;
    }
    private record Pair(char task, int time){}
}
