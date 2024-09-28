package edu.example.arrays;

public class KadaneAlgo {
    public int getMaxSum(int[] arr){
        int len = arr.length;
        if(len == 0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            int sum = arr[i];
            for(int j = i+1; j < len; j++){
                sum += arr[j];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
    public int getMaxSumOptimized(int[] arr){
        int len = arr.length;
        if(len == 0){
            return 0;
        }
        int maxSum = arr[0], maxSumHere = arr[0];
        for(int i = 1; i < len; i++){
            maxSumHere = Math.max(arr[i], maxSumHere + arr[i]);
            maxSum = Math.max(maxSum, maxSumHere);
        }
        return maxSum;
    }
    public int[] getIndexOfLargestSum(int[] arr){
        int len = arr.length;
        if(len == 0){
            return null;
        }
        int maxSum = arr[0], maxSumHere = arr[0], end = 0;
        for(int i = 1; i < len; i++){
            maxSumHere = Math.max(maxSumHere + arr[i], maxSum);
            if(maxSumHere > maxSum){
                end = i;
                maxSum = maxSumHere;
            }
        }
        int sum= 0;
        for(int i = end; i >= 0; i--){
             sum+=arr[i];
            if(maxSumHere == sum){
                return new int[]{i, end};
            }
        }
        return null;
    }
}
