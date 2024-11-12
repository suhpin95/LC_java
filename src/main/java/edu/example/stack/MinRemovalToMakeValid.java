package edu.example.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * LC: 1249
 */
public class MinRemovalToMakeValid {
	/*Stack<Integer> stack = new Stack<>();
	Set<Integer> hashSet = new HashSet<>();
	public String minRemovalToMakeValid(String str){
		int len = str.length();
		if(len == 0){
			return str;
		}
		for(int i = 0 ; i < len; i++){
			if(str.charAt(i) == '('){
				stack.push(i);
			}
			if(str.charAt(i) == ')'){
				if(stack.isEmpty()){
					hashSet.add(i);
				}else {
					stack.pop();
				}
			}
		}

		while(!stack.isEmpty()){
			hashSet.add(stack.pop());
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < len; i++){
			if(hashSet.contains(i)){
				continue;
			}
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}*/

    private StringBuilder removeInvalidClosing(CharSequence string, Character opening, Character closing){
        StringBuilder sb = new StringBuilder();
        int len = string.length();
        int balance = 0;
        for(int i = 0 ; i < len; i++){
            char character = string.charAt(i);
            if(character == opening){
                balance += 1;
            }
            if(character == closing){
                if(balance == 0){
                    continue;
                }
                balance -= 1;
            }
            sb.append(character);
        }//for
        return sb;
    }
    public String minRemoveToMakeValid(String s) {
        // check the first half
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        // check the by reverseing
        result = removeInvalidClosing(result.reverse(), ')', '(');

        /// reverse again and return result
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        MinRemovalToMakeValid m = new MinRemovalToMakeValid();
        m.minRemoveToMakeValid("lee(t(c)o)de");
    }
}
