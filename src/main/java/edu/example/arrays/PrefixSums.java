package edu.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class PrefixSums {

    public int[] getPrefixSums(int[] arr, int target) {
        int len = arr.length;
        if(len == 0) return null;
        int sum = 0;
        Map<Integer, Integer> cacheSum = new HashMap<>();
        /**
         * We check the summations here, which would mean that
         * if reach from previous sum after encountering number of elements
         * at the same sum; we are looking at the elements we want
         */
        for(int i = 0; i < len; i++) {
            sum += arr[i];
            if(sum == target) {
                return new int[]{0, i};
            }
            if(cacheSum.containsKey(sum - target)) {
                return new int[]{cacheSum.get(sum - target) + 1, i};
            }
            cacheSum.put(sum, i);
        }
        return null;
    }
}
