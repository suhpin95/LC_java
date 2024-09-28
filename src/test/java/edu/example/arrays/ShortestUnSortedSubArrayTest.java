package edu.example.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortestUnSortedSubArrayTest {
    int[] arr;
    ShortestUnSortedSubArray subArray;
    @Before
    public void setUp() {
        arr = new int[]{1,3,5,2,6,4,7,8,9};
        subArray = new ShortestUnSortedSubArray();
    }
    @Test
    public void testCorrectSolutions(){
        int[] solution = subArray.getShortestUnSortedSubArray(arr);
        Assert.assertArrayEquals(solution, new int[]{1,5});
    }
}