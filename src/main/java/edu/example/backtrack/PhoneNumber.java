package edu.example.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    Map<Integer, String> phoneIndex = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        init();
        List<String> buffer = new ArrayList<>();
        getCombinationOfText(digits, buffer, 0, 0);
        return buffer;
    }
    private void getCombinationOfText(String digits, List<String> buffer, int startIndex, int bufferIndex){
        if(bufferIndex == digits.length()){
            buffer.add(String.valueOf(digits.charAt(startIndex)));
            return ;
        }
        String characters = phoneIndex.get(digits.charAt(startIndex));
        if(characters.equals("")){
            getCombinationOfText(digits, buffer, startIndex+1, bufferIndex);
        }
        for(char c : characters.toCharArray()){
            buffer.add(String.valueOf(c));
            getCombinationOfText(digits, buffer, startIndex+1, bufferIndex+1);
            buffer.remove(buffer.size()-1);
        }
    }

    private void init(){
        phoneIndex.put(1, "");
        phoneIndex.put(2, "abc");
        phoneIndex.put(3, "def");
        phoneIndex.put(4, "ghi");
        phoneIndex.put(5, "jkl");
        phoneIndex.put(6, "mno");
        phoneIndex.put(7, "pqrs");
        phoneIndex.put(8, "tuv");
        phoneIndex.put(9, "wxyz");
        phoneIndex.put(0, "");
    }
}
