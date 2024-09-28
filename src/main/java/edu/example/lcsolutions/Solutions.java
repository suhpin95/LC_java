package edu.example.lcsolutions;

import java.util.*;

public class Solutions {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int target = nums[i] + nums[left] + nums[right];
                if(target == 0){
                    result.add((new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]))));
                    while(left < right && nums[left] == nums[left+1])left++;
                    while(left < right && nums[right] == nums[right-1])right--;
                    left++;
                    right--;
                }
                if(target < 0){
                    left++;
                }
                if(target > 0){
                    right--;
                }
            }
        }
        return result;
    }

    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return -1;
        }
        int left = 0, right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left < right){
            int area = calculateArea(height, left, right);
            maxArea = Math.max(area, maxArea);
	        if(height[left] < height[right]){
		    left++;
	        }
            else{
                right--;
            }
        }
        return maxArea;
    }
    private int calculateArea(int[] nums, int left, int right){
        int height = Math.min(nums[left], nums[right]);
        int width = right - left;
        return height * width;
    }

    Map<Character, Character> map;
    public boolean isValid(String s) {
        if(s.length() == 0){
            return false;
        }
        init();
        Stack<Character> stack = new Stack<>();
        for(char character : s.toCharArray()){
            char top = stack.pop();
            if(map.containsKey(character)){
                if(top != map.get(character)){
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.empty();
    }
    private void init(){
        map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

}
