package edu.example.stack;

import java.util.Stack;

public class SimplyUnixPath {
    public String simplifyPath(String path) {
        var result = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str: result){
            // checks to avoid the string// since it means we are in the same branch
            if(str.equals(".") || str.isEmpty()){
                continue;
            } else if(str.equals("..")){
                // encountering parent directory. delete from the top of the stack
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        // build the string
        StringBuilder relativePath = new StringBuilder();
        for(String str: stack){
            relativePath.append("/")
                    .append(str);
        }
        return !relativePath.isEmpty() ? relativePath.toString() : "/";
    }
}
