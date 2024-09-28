package edu.example.arrays;

public class ShortestUnSortedSubArray {
    public int[] getShortestUnSortedSubArray(int[] arr) {
        int len = arr.length;
        if(len == 0) {
            return null;
        }
        int[] result = new int[]{};
        int start = 0;
        int end = len - 1;

        start = getFirstDip(arr);
        end = getFirstBump(arr);

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++) {
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }

        while (start > 0 && arr[start - 1] > minVal) {
            start--;
        }
        while(end < len && arr[end] < minVal) {
            end++;
        }
        result = new int[]{start, end};
        return result;
    }
    private int getFirstDip(int[] arr) {
        int start = 0;
        for(start = 0 ;start < arr.length ;start ++) {
            if(arr[start] > arr[start + 1]) {
                break;
            }
        }
        return start;
    }

    private int getFirstBump(int[] arr) {
        int end= 0;
        for(end = arr.length - 1; end >= 0; end --) {
            if(arr[end-1] > arr[end]) {
                break;
            }
        }
        return end;
    }
}
