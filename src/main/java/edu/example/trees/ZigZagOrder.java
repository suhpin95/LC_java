package edu.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrder {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                TreeNode node = queue.poll();
                List<Integer> list = new ArrayList<>();
                if(node != null) {
                    if(!leftToRight) {
                        list.add(0, node.val);
                    }else{
                        list.add(node.val) ;
                    }
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            leftToRight = !leftToRight;
        }
        return result;
    }
}
