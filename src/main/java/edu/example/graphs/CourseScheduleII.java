package edu.example.graphs;

import java.util.*;

public class CourseScheduleII {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Stack<Integer> orderOfCourses = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isCycle = false;
        buildAdjacencyList(prerequisites, numCourses);
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(i, visited)){
                return new int[]{};
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while(!orderOfCourses.isEmpty()){
            result[index] = orderOfCourses.pop();
            index++;
        }
        return result;
    }
    private boolean hasCycle(int course, int[] visited) {
        // VISITING STATE
        if(visited[course] == 1) return true;
        // ALREADY VISITED
        if(visited[course] == 2)return false;
        visited[course] = 1;
        for(int neighbor : graph.get(course)){
            if(hasCycle(neighbor, visited)){
                return true;
            }
        }
        // visited state
        visited[course] = 2;
        orderOfCourses.push(course);
        return false;
    }
    private void buildAdjacencyList(int[][] prerequisites, int numCourses){
        for(int i = 0 ; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int required = prerequisite[1];
            graph.get(required).add(course);
        }
    }
}
