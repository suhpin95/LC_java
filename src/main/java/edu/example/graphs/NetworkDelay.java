package edu.example.graphs;

import java.util.*;

public class NetworkDelay {
    Map<Integer, List<Pairs>> graph;
    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i+1, new ArrayList<>());
        }
        for(int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int weight = time[2];
            graph.get(src).add(new Pairs(dest, weight));
        }
        Queue<Pairs> queue = new PriorityQueue<>((a, b) -> a.weight() - b.weight());
        queue.add(new Pairs(k, 0));
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        while(!queue.isEmpty()) {
            Pairs node = queue.poll();
            int dest = node.dest();
            int weight = node.weight();
            if(visited.contains(dest)) {
                continue;
            }
            visited.add(dest);
            cost = Math.max(cost, weight);
            for(Pairs neighbors : graph.get(dest)){
                if(!visited.contains(neighbors.dest())) {
                    queue.add(new Pairs(neighbors.dest(), weight + neighbors.weight()));
                }
            }
        }
        return visited.size() == n ? cost : -1;
    }
}
record Pairs(int dest, int weight){}
