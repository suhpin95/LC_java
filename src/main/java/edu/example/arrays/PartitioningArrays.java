package edu.example.arrays;

import java.util.Arrays;

public class PartitioningArrays {
    public int[] getZerosOnLeft(int[] arr){
        int len = arr.length;
        if(len == 0 ){
            return new int[0];
        }
        int boundry = 0;
        for(int i = 0; i < len; i++){
            if(arr[i] == 0){
                arr=swap(arr, boundry, i);
                boundry++;
            }

        }
        return arr;
    }
    private int[] swap(int[] arr, int i, int j){
         int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public int[] solveDutchFlag(int[] arr, int pivot){
        int len= arr.length;
        if(len == 0 ){
            return new int[0];
        }
        int lowBoundry = 0, highBoundry = len - 1;
        int index = 0;
        while(index <= highBoundry){
            if(arr[index] < pivot){
                arr = swap(arr, index, lowBoundry);
                index++;
                lowBoundry++;
            }
            else if(arr[index] > pivot){
                arr = swap(arr, index, highBoundry);
                highBoundry--;
            }
            else{
                index++;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
        return arr;
    }
}
