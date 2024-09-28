package edu.example.binarysearch;

public class SearchAlgo {
    public void getIndex(int[] arr, int target) {
        // normal binary search algo.
    }
    public int getFirstIndexOfTarget(int[] arr, int target) {
        int end = arr.length - 1;
        int start = 0;
        while(start <= end){
            int mid = (start + (end - start) ) /2;
            if((arr[mid] > target) || (arr[mid] == target && arr[mid - 1] == arr[mid] && mid > 0)){
                end = mid - 1;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
