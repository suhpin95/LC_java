package edu.example.arrays;

public class ReverseTraversal {

    public int[] getCloneArray(int[] arr) {
        int length = arr.length;
        int index = getIndexOfLastNum(arr);
        int end = length;
        while(index >= 0){
            if(arr[index] % 2 == 0){
                arr[--end] = arr[index];
            }
            arr[--end] = arr[index];
            index--;
        }
        return arr;
    }

    private int getIndexOfLastNum(int [] arr){
        int length = arr.length - 1;
        while( length >= 0 && arr[length] == -1){
            length--;
        }
        return length;
    }
}
