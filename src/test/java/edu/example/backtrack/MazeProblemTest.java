package edu.example.backtrack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MazeProblemTest {

    int[][] maze;
    MazeProblem mazeProblem;
    @Before
    public void setUp() throws Exception {
        maze = new int[][]{
                {0, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 0}

        };
        mazeProblem = new MazeProblem();
    }

    @Test
    public void testMazeProblem() {
        boolean actualValue = mazeProblem.hasPath(maze);
        assertTrue(actualValue);
    }
}