package edu.example.lcsolutions;

import java.util.*;

class Solution {
    Map<String, List<String>> map;

    /**
     * Group Anagrams
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return null;
        }
        map = new HashMap<>();
        for(int i = 0 ; i < strs.length; i++){
            char[] characters = strs[i].toCharArray();
            // use frequency counter
            int[] frequencyCounter = new int[26];
            for(char character: characters ){
                int ascii = character - 'a';
                frequencyCounter[ascii]++;
            }
            StringBuilder key = new StringBuilder();
            for(int val : frequencyCounter){
//                There could be a possibility where string appending can lead to same key's for different anagram. hence adding a delimiter
                key.append(val+"#");
            }
            String hash = key.toString();
            // build string of the values
            // Arrays.sort(characters);
            // String key = new String(characters);
            if(!map.containsKey(hash)){
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(strs[i]);

        }
        return new ArrayList<>(map.values());
    }

    /**
     * Longest Consecutive Sequence
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int val : nums){
            numbers.add(val);
        }
        int maxLen = 0;
        for (int element : numbers) {
            if (!numbers.contains(element - 1)) {
                continue;
            }
            int len = 0;
            while (numbers.contains(element++)) {
                len++;
            }
            maxLen = (Math.max(maxLen, len));
        }
        return maxLen;
    }

    public boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        String str = transform(s);
        int left = 0, right = s.length()-1;
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private String transform(String str){
        str = str.replaceAll("[^a-zA-z0-9_]", "");
        return str.toLowerCase();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> test= solution.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        test.forEach(element -> element.forEach(System.out::println));
        System.out.println(test.size());
    }


    /**
     * Best Time to Buy Stock - 1
     */

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int minPrice = prices[0], maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - minPrice;
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}