package edu.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return result;
        }
        List<String> buffer = new ArrayList<>();
        backTrack(0, n, buffer, 0 , 0);
        return result;
    }
    private void backTrack(int index, int len, List<String> buffer, int leftCount, int rightCount){
        if(index > 2 * len){
            String output = String.join("", buffer);
            result.add(output);
            return;
        }
        if(leftCount < len){
            buffer.add("(");
            backTrack(index + 1, len, buffer, leftCount, rightCount+1);
            buffer.remove(buffer.size()-1);

        } else {
            buffer.add(")");
            backTrack(index + 1, len, buffer, leftCount + 1, rightCount);
            buffer.remove(buffer.size()-1);
        }
    }
}
