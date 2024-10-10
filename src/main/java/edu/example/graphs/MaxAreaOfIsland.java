package edu.example.graphs;

public class MaxAreaOfIsland {
    int COLLEN ,ROWLEN;
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        COLLEN = grid[0].length;
        ROWLEN = grid.length;
        if(ROWLEN == 0 || COLLEN == 0) {
            return 0;
        }
        for(int row = 0 ; row < ROWLEN ; row++) {
            for(int col = 0 ; col < COLLEN ; col++) {
                result = Math.max(dfs(row, col, grid), result);
            }
        }
        return result;
    }
    private int dfs(int row, int col, int[][] grid) {
        if(row < 0 || row >= ROWLEN || col < 0 ||  col >= COLLEN || grid[row][col] != 1){
            return 0;
        }
        grid[row][col] = -1;
        int up = dfs(row - 1, col , grid);
        int down = dfs(row + 1, col, grid);
        int left = dfs(row, col - 1, grid);
        int right = dfs(row, col + 1, grid);
        return 1+left+right+up+down;
    }
}
