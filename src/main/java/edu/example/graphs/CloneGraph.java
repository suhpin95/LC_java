package edu.example.graphs;

import java.util.*;

public class CloneGraph {
    Map<Node, Node> cache = new HashMap<>();
    public Node cloneGraph(Node node) {
        bfs(node);
        return cache.get(node);
    }
    /**
     private Node dfs(Node node){
     if(node == null){
     return node;
     }
     if(cache.containsKey(node)){
     return cache.get(node);
     }
     Node newNode = new Node(node.val);
     cache.put(node, newNode);
     List<Node> neighbors = node.neighbors;
     for(Node neighbor : neighbors){
     newNode.neighbors.add(dfs(neighbor));
     }
     return newNode;
     } */

    private void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        cache.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            List<Node> neighbors = current.neighbors;
            for(Node neighbor: neighbors){
                if(!cache.containsKey(neighbor)){
                    cache.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                cache.get(current).neighbors.add(cache.get(neighbor));
            }
        }
    }


    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
