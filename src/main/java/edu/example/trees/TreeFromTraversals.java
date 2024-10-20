package edu.example.trees;

import java.util.HashMap;
import java.util.Map;

public class TreeFromTraversals {
    Map<Integer, Integer> cache = new HashMap<>();
    int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        setCachingForInorder(inorder, len);
        int inorderStart = 0, inorderEnd = inorder.length - 1;
        return constructTree(preorder, inorderStart, inorderEnd);
    }

    private void setCachingForInorder(int[] inorder, int len) {
        for(int i = 0; i < len; i++){
            cache.put(inorder[i], i);
        }
    }

    private TreeNode constructTree(int[] preorder, int inorderStart, int inorderEnd) {
        if(inorderStart > inorderEnd ){
            return null;
        }
        int val = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(val);
        root.left = constructTree(preorder, inorderStart, cache.get(val) - 1);
        root.right = constructTree(preorder,  cache.get(val) + 1, inorderEnd);
        return root;
    }
}
