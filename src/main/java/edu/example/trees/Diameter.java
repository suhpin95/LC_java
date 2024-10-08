package edu.example.trees;

public class Diameter {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return res;
    }
    private int recurse(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = recurse(root.left);
        int right = recurse(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }
}