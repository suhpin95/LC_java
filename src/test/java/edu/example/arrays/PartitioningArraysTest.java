package edu.example.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitioningArraysTest {

    int[] arr;
    PartitioningArrays partitioningArrays;
    @Before
    public void setUp() throws Exception {
        partitioningArrays = new PartitioningArrays();
        arr= new int[]{5, 2, 4, 8, 6, 4, 1};
    }

//    @Test
//    public void testSolution(){
//        int[] solutions = partitioningArrays.getZerosOnLeft(arr);
//        Assert.assertArrayEquals(solutions, new int[]{0,0,0,1,2,3,4});
//    }
    @Test
    public void testSolution2(){
//        arr= new int[]{5, 2, 4, 8, 6, 4, 1};
        partitioningArrays.solveDutchFlag(arr, 4);
    }
}