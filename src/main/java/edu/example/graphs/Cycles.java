//package edu.example.graphs;
//
//public class Cycles {
//    public boolean hasCycle(Graph graph) {
//        if(graph == null) return false;
//        return dfs(graph);
//    }
//    private boolean dfs(Graph graph) {
//        if(graph.state == State.VISITED){
//            return true;
//        }
//        graph.state= State.VISITING;
//        for(Node node: graph.getNeighbors()){
//            if(node.state = State.UNVISITED && dfs(node)){
//                return true;
//            } else if (node.state = State.VISITING) {
//                return false;
//            }
//        }
//        node.state = State.VISITED;
//        return false;
//    }
//    private enum State {
//        VISITING,
//        VISITED,
//        UNVISITED
//    }
//}
//class Graph{
//
//}
