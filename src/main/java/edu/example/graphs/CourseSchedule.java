package edu.example.graphs;

import java.util.*;

public class CourseSchedule {
    Map<Integer, List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || numCourses == 0) throw new IllegalArgumentException();
        init();
        buildAdjacencyList(prerequisites);
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            // if there's a cycle we can't finish
            if(hasCycle(i, visited)){
                return false;
            }
        }
        // else we can
        return true;
    }
    private void init(){
        graph = new HashMap<>();
    }
    private void buildAdjacencyList(int[][] prerequisites){
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int required = prerequisite[1];
            if(!graph.containsKey(course)){
                graph.put(course, new ArrayList<>());
            }
            graph.get(course).add(required);
        }
    }
    private boolean hasCycle(int course, Set<Integer> visited) {
        // already visited, has cycle
        if(visited.contains(course)) return true;
        // already visited entire prereqs, there's no cycle
        if(graph.get(course) == null ) return false;
        //marking as visited
        visited.add(course);
        for(int neighbor : graph.get(course)){
            if(hasCycle(neighbor, visited)) return true;
        }
        // removing from th after completion
        visited.remove(course);
        graph.put(course, null);
        return false;
    }
}
