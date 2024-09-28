package edu.example.graphs;

import java.util.*;

public class LevelOrder {

    Map<Integer, List<Node>> graph;
    public LevelOrder(){
        graph = new HashMap<>();
    }

    public List<Integer> getLevelOrder(Node root){
        if(root == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();
        Set<Node> visitedNode =  new HashSet<>();
        currentLevel.add(root);
        while(!currentLevel.isEmpty()){
            Node currentNode = currentLevel.poll();
            List<Node> neighbors = graph.get(currentNode);
            for(Node neighbor: neighbors){
                if(!visitedNode.contains(neighbor)){
                    nextLevel.add(neighbor);
                }
            }
            visitedNode.add(currentNode);
            result.add(currentNode.getData());
            currentLevel = nextLevel;
        }
        return result;
    }
}
class Node{
    int data;
    List<Node> children;

    public int getData() {
        return data;
    }

    public List<Node> getChildren() {
        return children;
    }
}
