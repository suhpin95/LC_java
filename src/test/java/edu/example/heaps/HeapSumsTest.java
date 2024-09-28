package edu.example.heaps;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeapSumsTest {

    int[] arr;
    HeapSums hs;
    @Before
    public void setUp() throws Exception {
        arr = new int[]{6,3,6,6,2,2,4};
        hs = new HeapSums();
    }
    @Test
    public void testHeapSum() {
        Object[] actualValue = hs.printKSmallest(arr, 4);
        Object[] expectedValue = new Object[]{2,2,3,4};
        assertArrayEquals(expectedValue,actualValue);
    }
}