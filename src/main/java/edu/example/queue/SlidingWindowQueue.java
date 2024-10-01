package edu.example.queue;

import java.util.*;

public class SlidingWindowQueue {
    public List<Integer> getSum(int[] arr, int windowSize) {
        if(arr.length == 0 || windowSize <= 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        int sum = 0;
        for (int val : arr) {
            if (deque.size() == windowSize) {
                sum -= deque.poll();
            }
            deque.add(val);
            sum += val;
            if (deque.size() == windowSize) {
                result.add(sum);
            }
        }
        return result;
    }

    /**
     * Longest Substring Without Repeating Characters
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str) {
        int len = str.length();
        if(len == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, right = 0, left = 0;
        while(right < len) {
            char ch = str.charAt(right);
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    /**
     * 424. Longest Repeating Character Replacement
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int left = 0, maxLen = 0, max = 0 ;
        int[] freq = new int[26];

        for(int right = 0 ; right < s.length() ; right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            max = Math.max(max, freq[ch - 'A']);
            if(right - left + 1 - max  > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    /**
     * 567. Permutation in String
     */

    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        if(len > s2.length()){
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i = 0; i < len; i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        //find the number of matches by shifting the window
        //such that we are left matches equal to the original in different order
        for(int i = 0; i < s2.length() - len; i++){
            if(isMatch(s1Map, s2Map)){
                return true;
            }
            s2Map[s2.charAt(0) - 'a'] --;
            s2Map[s2.charAt(0) - 'a' + len]++;
        }
        return isMatch(s1Map,s2Map);
    }
    private boolean isMatch(int[] s1Map, int[] s2Map){
        for(int i = 0; i < s1Map.length; i++){
            if(s1Map[i] != s2Map[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SlidingWindowQueue slidingWindowQueue = new SlidingWindowQueue();
        slidingWindowQueue.checkInclusion("ab", "eidbaooo");
    }
}
