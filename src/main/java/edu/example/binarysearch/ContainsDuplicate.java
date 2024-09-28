package edu.example.binarysearch;

public class ContainsDuplicate {
    public int getIndex(int[] arr, int val) {
        int length = arr.length;
        if(length == 0) return -1;
        int start = 0, end = length - 1;
        while(start <= end) {
            int mid = (start  + (end - start) ) / 2;
            if( (mid > 0 && arr[mid - 1] == arr[mid] && arr[mid] == val) || arr[mid] > val){
                end = mid - 1;
            }
            else if(arr[mid] < val){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int getIndexToInsert(int[] arr, int val) {
        return -1;
    }
}
