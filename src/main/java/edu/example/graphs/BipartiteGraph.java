//package edu.example.graphs;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class BipartiteGraph {
//    public List getGraphs(Graph graph){
//        if(graph == null){
//            return null;
//        }
//        getBipartite(graph);
//    }
//    private void getBipartite(Graph graph){
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(graph);
//        List<Node> evenList = new ArrayList<>();
//        List<Node> oddList = new ArrayList<>();
//        while(!queue.isEmpty()){
//            Node node = queue.remove();
//            node.state = State.VISITING;
//            if(node.getLevel % 2 == 0){
//                evenList.add(node);
//            } else {
//                oddList.add(node);
//            }
//            for(Node neighbors: node.getChildren()){
//                if(node.state == States.UNVISITED){
//                    neighbors.setLevel(node.getLevel + 1);
//                    queue.add(neighbors);
//                } else if(node.getLevel() == neighbors.getLevel()){
//                    return null;
//                }
//            }
//            node.state = State.VISITED;
//        }
//    }
//}
