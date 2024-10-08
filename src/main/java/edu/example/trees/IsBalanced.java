package edu.example.trees;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 2) {
            return -1;
        }
        // because we need depth to check and every level is converted to a root
        return Math.max(left , right) + 1;
    }
}
