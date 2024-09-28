package edu.example.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KadaneAlgoTest {

    int[] arr;
    KadaneAlgo kadaneAlgo;
    @Before
    public void setUp() throws Exception {
        arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
        kadaneAlgo = new KadaneAlgo();
    }
    @Test
    public void testKadaneAlgo() {
        int actualResult = kadaneAlgo.getMaxSum(arr);
        Assert.assertEquals(7, actualResult);

    }
    @Test
    public void testOptimizedKadaneAlgo() {
        int actualResult = kadaneAlgo.getMaxSumOptimized(arr);
        Assert.assertEquals(7, actualResult);
    }
}