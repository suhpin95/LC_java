package edu.example.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsGate {
    public void wallsAndGates(int[][] rooms) {
        Integer INF = Integer.MAX_VALUE;
        Integer GATE = 0;
        Integer WALL = -1;
        // perform multi path bfs, such that we update the part with the distance value everytime
        // for this we need to mark and add the value in to the Queue
        Queue<Location> queue = new LinkedList<>();
        int ROWLEN = rooms.length;
        int COLLLEN = rooms[0].length;
        for(int row = 0; row < ROWLEN; row++) {
            for(int col = 0; col < COLLLEN; col++) {
                if(rooms[row][col] == GATE) {
                    queue.add(new Location(row, col));
                }
            }
        }
        int distance = 0;
        int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()) {
            Location location = queue.poll();
            int row = location.row();
            int col = location.col();
            // update the distance
            for(int[] dir : DIR) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow < 0 || newRow >= ROWLEN || newCol < 0 || newCol >= COLLLEN) {
                    continue;
                }
                distance++;
                rooms[newRow][newCol] = rooms[row][col] + distance;
                queue.add(new Location(newRow, newCol));
            }
        }

    }
}
record Location(int row, int col) {}
