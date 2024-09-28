package edu.example.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReverseTraversalTest {

    int[] arr;
    @Before
    public void init() {
        arr = new int[]{1, 3, 4, 5, 7, -1};
    }
    @Test
    public void testEvenElements(){
        ReverseTraversal rt = new ReverseTraversal();
        int[] solution = rt.getCloneArray(arr);

        Assert.assertArrayEquals(new int[] {1, 3, 4, 4, 5, 7}, solution);
        Assert.assertTrue(solution.length == arr.length)    ;
    }
}