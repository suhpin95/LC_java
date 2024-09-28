package edu.example.backtrack;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationTest {

    Combination combination;
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr = new int[]{1,2,4,6};
        combination = new Combination();
    }
    @Test
    public void testCombination() {
        int size = 3;
        List<List<Integer>> result = combination.printCombo(arr, size);
        int expectLength = 4;
        assertEquals(expectLength, result.size());
    }
}