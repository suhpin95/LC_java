//package edu.example.graphs;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Stack;
//
//public class TopSortAlgo {
//    /**
//     * Given a graph, determine the number of semester it would take to complete the course
//     */
//    Stack<Node> courseOrder = new Stack<>();
//    Map<Integer, List<Integer>> graph;
//    public int getNumOfSemester(){
//        if(graph.isEmpty()){
//            return -1;
//        }
//        for(int i = 0 ; i < graph.size() ; i++){
//            for(Node node : graph.get(i)){
//                if(node.state = states.UNVISITED){
//                    dfs(node);
//                }
//            }
//        }
//
//        // perform dfs
//        // and process each node and put them in stack
//        // return stack.length
//        return courseOrder.length();
//    }
//
//    private void dfs(Node node){
//        if(node.state == State.VISITED){
//            return;
//        }
//        node.setState(State.VISITNG);
//        for(Node newNode : node.getNeighbors()){
//            if(newNode.getState() == UNVISITED){
//                dfs(newNode);
//            }
//        }
//        node.getStates();
//        courseOrder.push(node);
//    }
//    private class Node {
//        int data;
//        State states;
//
//        public int getData() {
//            return data;
//        }
//
//        public State getStates() {
//            return states;
//        }
//    }
//    private enum State{
//        VISITNG,
//        UNVISITING,
//        VISITED
//    }
//}
