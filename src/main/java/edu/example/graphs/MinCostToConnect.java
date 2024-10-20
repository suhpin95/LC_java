package edu.example.graphs;

import java.util.*;

public class MinCostToConnect {

    public int minCostConnectPoints(int[][] points) {
        Queue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.weight() - b.weight());
        minHeap.add(new Pair(0,0));

        Set<Integer> visited = new HashSet<>();
        int totalWeight = 0;

        while(minHeap.size() < points.length) {
            Pair pair = minHeap.poll();
            int node = pair.node();
            int cost = pair.weight();
            if(visited.contains(node)) {
                continue;
            }
            visited.add(node);
            totalWeight += cost;
            int[] newPoint = points[node];
            int x1 = newPoint[0];
            int y1 = newPoint[1];
            for(int i = 0; i < points.length; i++) {
                if(!visited.contains(i)) {
                   int[] delta = points[i];
                   int newX = delta[0];
                   int newY = delta[1];
                   minHeap.add(new Pair(getDistance(x1, y1, newX, newY), i));
                }
            }
        }
        return totalWeight;
    }
    private int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
record Pair(int weight, int node){}