package edu.example.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KSmallestElement {
    // recursive approach
    /**
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result= dfs(root, new ArrayList<Integer>());
        return result.get(k-1);
    }
    private List<Integer> dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return null;
        }
        // inorder
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
        return result;
    }
     */

    //
    public int kthSmallest(TreeNode root, int k) {
       Stack<TreeNode> stack = new Stack<>();
       TreeNode current = root;
       int count = 0;;
       while(!stack.empty() && current!=null) {
           while(current!=null) {
               stack.push(current);
               current = current.left;
           }
           count++;
           current = stack.pop();
           if(count==k) {
               return current.val;
           }
           current = current.right;
       }
       return -1;
    }
}
