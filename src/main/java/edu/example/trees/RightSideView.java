package edu.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(i == size - 1) {
                    result.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
