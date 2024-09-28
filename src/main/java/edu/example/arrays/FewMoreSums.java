package edu.example.arrays;

public class FewMoreSums {
    public boolean isRotation(String input, String compareString){
        if(input.isEmpty()){
            return false;
        }
        String concatString = input.concat(input);
        return concatString.contains(compareString);
    }
    public String reverseWords(String input){
        // reverse the entire string character by character
        if(input.isEmpty()){
            return input;
        }
        int wordStart = 0;
        // Complete reverse
        reverseChars(input, 0, input.length());
        // Word by word reverse
        for(int i = 0; i < input.length() - 1; i++){
            if(input.charAt(i) == ' '){
                reverseChars(input, wordStart, i);
                wordStart = i + 2;
            }
        }
        reverseChars(input, wordStart, input.length() - 1);
        return input;
    }
    private String reverseChars(String input, int start, int end){
        char[] characters = input.toCharArray();
        while(start < end){
            swap(input, start, end);
        }
        return input;
    }
    private void swap(String character, int start, int end){
         char temp = character.charAt(start);
         character.toCharArray()[start] = character.toCharArray()[end];
         character.toCharArray()[end] = temp;
    }

    /**
     * Longest Palindromic substring
     */
}
