package edu.example.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        List<Integer> buffer = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(0, buffer, result, nums);
        return result;
    }
    private void backTrack(int index, List<Integer> buffer, List<List<Integer>> result, int[] nums){
        result.add(new ArrayList<>(buffer));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1])continue;
            buffer.add(nums[i]);
            backTrack(i+1, buffer, result, nums);
            buffer.remove(buffer.size()-1);
        }
    }
}
