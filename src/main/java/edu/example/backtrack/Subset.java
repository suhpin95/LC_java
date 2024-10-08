package edu.example.backtrack;

import java.util.*;

public class Subset {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> buffer = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        backTrack(0, nums);
        return result;
    }
    private void backTrack(int index, int[] nums){
        result.add(new ArrayList<>(buffer));
        for(int i = index ; i < nums.length; i++){
            buffer.add(nums[i]);
            backTrack(i + 1, nums);
            buffer.remove(nums[i]);
        }
    }
}
