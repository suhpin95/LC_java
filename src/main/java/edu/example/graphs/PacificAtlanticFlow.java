package edu.example.graphs;

import java.util.*;

public class PacificAtlanticFlow {
    int ROWLEN = 0;
    int COLLEN = 0;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // we need to perform dfs or bfs
        // we need to mark the visited row,col
        ROWLEN = heights.length;
        COLLEN = heights[0].length;

        // we need to perform dfs only on the edges of the grid
        int[][] pacific = new int[ROWLEN][COLLEN];
        int[][] atlantic = new int[ROWLEN][COLLEN];
        // from the edge we perform dfs

        for(int row = 0; row < ROWLEN; row++){
            bfs(pacific, heights[row][0], heights, row, 0);
            bfs(atlantic, heights[row][COLLEN-1], heights, row, COLLEN-1);
        }
        for(int col = 0; col < COLLEN; col++){
            bfs(pacific, heights[0][col], heights, 0, col);
            bfs(atlantic, heights[ROWLEN-1][col], heights, ROWLEN-1, col);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0 ; row < ROWLEN; row++){
            for(int col = 0 ; col < COLLEN; col++){
                if(atlantic[row][col] == 1 && pacific[row][col] == 1){
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] ocean,int prevHeight, int [][] height, int row, int col){
        // boundary conditions
        if(row < 0 || row >= ROWLEN || col < 0 || col >= COLLEN || ocean[row][col] == 1){
            return;
        }
        // water flows the next cell if the current cell has more height than the adjacent

        if(prevHeight <= height[row][col]){
            ocean[row][col] = 1;
            dfs(ocean, height[row][col], height, row + 1, col);
            dfs(ocean, height[row][col], height, row - 1, col);
            dfs(ocean, height[row][col], height, row, col + 1);
            dfs(ocean, height[row][col], height, row, col - 1);
        }
    }
    private void bfs(int[][] ocean,int prevHeight, int [][] height, int row, int col){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        int[][] DIR = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // visited
        ocean[row][col] = 1;
        while(!queue.isEmpty()){
            Pair location = queue.poll();
            int prevRow = location.row();
            int prevCol = location.col();
            for(int[] dir : DIR){
                int newRow = prevRow + dir[0];
                int newCol = prevCol + dir[1];
                if(newRow < 0 || newRow >= ROWLEN || newCol < 0 || newCol >= COLLEN || ocean[newRow][newCol] == 1){
                    continue;
                }
                if(height[prevRow][prevCol] <= height[newRow][newCol]){
                    ocean[newRow][newCol] = 1;
                    queue.add(new Pair(newRow, newCol));
                }
            }

        }
    }
    private record Pair(int row, int col){}
}
