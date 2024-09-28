package edu.example.binarysearch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchAlgoTest {

    int[] arr;
    SearchAlgo searchAlgos;
    @Before
    public void setUp() throws Exception {
        arr = new int[]{1,2,2,4,5};
        searchAlgos = new SearchAlgo();
    }
    @Test
    public void testSearch() {
        int target = 2;
        int expected = 1;
        int actual = searchAlgos.getFirstIndexOfTarget(arr, target);
        Assert.assertEquals(expected, actual);
    }
}