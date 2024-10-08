package edu.example.trees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        return dfs(root, left, right);
    }
    private boolean dfs(TreeNode root, int minValLeft, int maxValRight){
        if(root == null){
            return true;
        }
        if(!(root.val > minValLeft && root.val < maxValRight)){
            return false;
        }

        return(
                // update the leftVal and rightVal
                dfs(root.left, minValLeft, root.val)
                        &&
                dfs(root.right, root.val, maxValRight)
        );
    }
}
