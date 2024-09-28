package edu.example.arrays;

public class TwoSum {
    public int[] getIndex(int[] arr, int target) {
        int[] result = new int[2];
        int len = arr.length;
        if(len == 0){
            return null;
        }
        int i = 0, j = len-1;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                result = new int[]{i, j};
            }
            else if(sum < target){
                i++;
            } else if(sum > target) {
                j--;
            }
        }
        return result;
    }
}
