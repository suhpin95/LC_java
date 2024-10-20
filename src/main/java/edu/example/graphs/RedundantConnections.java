package edu.example.graphs;

public class RedundantConnections {
    int[] rank, root;
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        rank = new int[len + 1];
        root = new int[len + 1];
        for(int i = 0 ; i < len; i++){
            root[i] = i;
        }
        for(int[] edge: edges){
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            if(union(vertex1, vertex2)){
                return edge;
            }
        }
        return new int[len];
    }

    private int find(int node){
        while(node != root[node]){
            node = root[node];
        }
        return root[node];
    }
    private boolean union(int node1, int node2){
        int vertex1 = find(node1);
        int vertex2 = find(node2);
        if(vertex1 == vertex2){
            return true;
        } else if(rank[vertex1] < rank[vertex2]){
            root[vertex2] = vertex1;
        } else if(rank[vertex1] > rank[vertex2]){
            root[vertex1] = vertex2;
        } else {
            root[vertex2] = vertex1;
            rank[vertex2]++;
        }
        return false;
    }
}
