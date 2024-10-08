package edu.example.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    /**
     * BFS
     * @param root
     * @return
     */
    /*
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
    */

    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return maxRecurse(root);
    }
    private int maxRecurse(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxRecurse(root.left) + 1, maxRecurse(root.right) + 1);
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }