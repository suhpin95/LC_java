package edu.example.trees;

import com.sun.source.tree.Tree;

public class FindLCA {
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode current = root, result = null;
        while(current != null) {
            if(current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if(current.val < p.val && current.val < q.val) {
                current = current.right;
            } else {
                result = current;
                break;
            }
        }
        return result;
    }
}
