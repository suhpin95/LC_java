package edu.example.backtrack;

import java.util.*;

public class WordBreak {
    HashSet<String> dictionary;
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s) {
        if(s.isEmpty()){
            return new ArrayList<>();
        }
        States[] memo = new States[s.length()];
        Arrays.fill(memo, States.NOT_VISITED);
        if(getWords(s, 0, memo)){
            return result;
        }
        return null;
    }
    private boolean getWords(String s, int index, States[] memo){
        if(index == s.length()){
            return true;
        }
        if(memo[index] == States.NO_PATHFOUND){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            String candidate = s.substring(index, i + 1);
            if(dictionary.contains(candidate)){
                result.add(candidate);
                if(getWords(s, i + 1, memo)){
                    return true;
                } else {
                    result.remove(candidate);
                    memo[i+1] = States.NO_PATHFOUND;
                }
            }
        }
        return false;
    }

    public enum States{
        NOT_VISITED,
        NO_PATHFOUND
    }
}
