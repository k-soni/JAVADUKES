package com.ksoni.javadukes.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleInDirectedGraph {

    public static void main(String[] args) {

    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Set<Integer> nodeSet = new HashSet<>();
        boolean[] visited = new boolean[A+1];
        ArrayList<ArrayList<Integer>> directedGraph = getDirectedGraph(A, B);

        for (int i = 1; i <= A; i++) {
            if(!visited[i]) {
                if( dfs(directedGraph, i, nodeSet, visited) == 1 ) {
                    return 1;
                }
            }
        }

        return 0;
    }


    private int dfs(ArrayList<ArrayList<Integer>> B, int src, Set<Integer> nodeSet, boolean[] visited) {
        visited[src] = true;
        nodeSet.add(src);

        ArrayList<Integer> neighbors = B.get(src);
        for (int i = 0; i < neighbors.size(); i++) {
            int neighbor = neighbors.get(i);
            if(nodeSet.contains(neighbor)) {
                return 1;
            }
            if(visited[neighbor] == false) {
                if(dfs(B,neighbor,nodeSet, visited) == 1) {
                    return 1;
                } ;
            }
        }
        nodeSet.remove(src);
        return 0;

    }

    private ArrayList<ArrayList<Integer>> getDirectedGraph(int nodes, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0);
            int v = B.get(i).get(1);
            graph.get(u).add(v);
        }

        return graph;
    }
}
