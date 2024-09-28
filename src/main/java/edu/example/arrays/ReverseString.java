package edu.example.arrays;

public class ReverseString {
    // Give a string return the reverse of the words string
    public String getReverseString(String input) {
        int len = input.length();
        if(len == 0 || input.equals(null) ){
            return "";
        }
        StringBuilder reverseString = new StringBuilder();
        int index = len - 1;
        while(index >= 0){
            if(input.charAt(index) == ' '){
                if(!reverseString.isEmpty()){
                    reverseString.append(' ');
                }
                reverseString.append(input.substring(index+1, len));
                len = index;
            }
            index--;
        }
        String firstWord = input.substring(0, len);
        if(!reverseString.isEmpty()){
            reverseString.append(' ');
        }
        reverseString.append(firstWord);
        return reverseString.toString();
    }
}
