package edu.example.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixSumsTest {

    int[] arr;
    PrefixSums prefixSums;
    @Before
    public void setUp() throws Exception {
        arr = new int[] {2,4,-2,1,-3,5,-3};
        prefixSums = new PrefixSums();
    }
    @Test
    public void testPrefixSums() {
        int target = 5;
        int[] solution = prefixSums.getPrefixSums(arr, target);
        int[] expected = new int[]{0,3};
        Assert.assertArrayEquals(expected, solution);
    }
}