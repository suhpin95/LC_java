package edu.example.trees;

import java.util.*;

public class LevelOrder {
    /*
    Queue<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.remove();
                level.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(level);
        }
        return result;
    } */
    Map<Integer, List<Integer>> cache = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return new ArrayList<>(cache.values());
    }
    private void dfs(TreeNode root, int level) {
        if(root != null) {
            if(cache.containsKey(level)) {
                cache.get(level).add(root.val);
            } else {
                cache.put(level, new ArrayList<>());
                cache.get(level).add(root.val);
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }
}
