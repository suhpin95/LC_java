package edu.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return result;
        List<String> buffer = new ArrayList<>();
        backTrack(s, 0, buffer);
        return result;
    }
    private void backTrack(String s, int startIndex, List<String> buffer) {
        if(startIndex >= s.length()) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        for(int end = startIndex; end < s.length(); end++) {
            if(isPalindrome(s, startIndex, end)){
                buffer.add(s.substring(startIndex, end+1));
                backTrack(s, end+1, buffer);
                buffer.remove(buffer.size()-1);
            }
        }
    }
    private boolean isPalindrome(String c, int start, int end) {
        while(start < end) {
            if(c.charAt(start) != c.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
