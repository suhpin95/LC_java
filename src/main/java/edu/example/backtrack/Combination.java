package edu.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    /**
     * Print all combinations of length 3.
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> printCombo(int[] nums, int size) {
        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }
        List<Integer> buffer = new ArrayList<>();
        getCombination(nums, buffer, 0, size);
        return result;
    }
    private void getCombination(int[] nums, List<Integer> buffer, int startIndex, int size){

        if(buffer.size() == size){
            result.add(new ArrayList<>(buffer));
            return;
        }
        if(startIndex > nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            buffer.add(nums[i]);
            getCombination(nums, buffer, i + 1, size);
            buffer.remove(buffer.size() - 1);
        }
    }
}
