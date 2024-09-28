package edu.example.backtrack;

import java.util.Arrays;

public class MazeProblem {
    private int ROW, COL;
    private State[][] memo;

    public boolean hasPath(int [][]maze){
        if(maze == null){
            return false;
        }
        ROW = maze.length;
        COL = maze[0].length;
        memo = new State[ROW][COL];
        for(State[] row : memo){
            Arrays.fill(row, State.NOT_VISITED);
        }
        return pathExists(maze, 0, 0);
    }

    private boolean pathExists(int [][]maze, int row, int col){
        if(row < 0 || row >= ROW || col < 0 || col >= COL || maze[row][col] != 0){
            return false;
        }
        if(memo[row][col] == State.VISITED || memo[row][col] == State.NO_PATH){
            return false;
        }
        if(row == ROW - 1 && col == COL - 1){
            return true;
        }
        memo[row][col] = State.VISITED;
        Pair[] pairs = {
                new Pair(row + 1, col),
                new Pair(row - 1, col),
                new Pair(row, col + 1),
                new Pair(row, col - 1),
        };
        for(Pair pair : pairs){
            if(pathExists(maze, pair.first(), pair.second())){
                return true;
            }
        }
        memo[row][col] = State.NO_PATH;
        return false;
    }

    public enum State {
        VISITED,
        NOT_VISITED,
        NO_PATH
    }

    record Pair(int first, int second){}
}



