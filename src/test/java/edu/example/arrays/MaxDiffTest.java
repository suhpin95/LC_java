package edu.example.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDiffTest {

    MaxDiff maxDiff;
    int[] arr;
    @Before
    public void setUp() throws Exception {
        maxDiff = new MaxDiff();
        arr = new int[]{8,14,2,5,7,3,9,5};
    }

    @Test
    public void testMaxDiff() {
        int expectedValue = maxDiff.getMaxProfit2(arr);
    }
}