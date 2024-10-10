package edu.example.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrange {
    Queue<Location> queue = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int ROWLEN = grid.length;
        int COLLEN = grid[0].length;
        int freshOranges = 0;
        final int EMPTY = 0;
        final int FRESH = 1;
        final int ROTTEN = 2;

        for (int i = 0; i < ROWLEN; i++) {
            for (int j = 0; j < COLLEN; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.add(new Location(i, j));
                }
                if (grid[i][j] == FRESH) {
                    freshOranges++;
                }
            }
        }
        int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty() && freshOranges != 0) {
            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {
                Location location = queue.remove();
                int row = location.row();
                int col = location.col();
                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow < 0 || newRow == ROWLEN || newCol < 0 || newCol == COLLEN || grid[newRow][newCol] != FRESH) {
                        continue;
                    }
                    grid[newRow][newCol] = ROTTEN;
                    freshOranges--;
                    queue.add(new Location(newRow, newCol));
                }
            }

        }
        return freshOranges == 0 ? time : -1;
    }
}

