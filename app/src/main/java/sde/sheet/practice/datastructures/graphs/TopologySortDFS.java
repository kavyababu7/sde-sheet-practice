package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologySortDFS {
    public static void main(String[] args) {
        List<List<Integer>> dag = GraphInitializer.buildDAG();
        int vertices = dag.size();
        boolean[] visited = new boolean[vertices];
        Stack<Integer> sortedPath = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(dag, i, visited, sortedPath);
            }
        }
        for (int i = 0; i < vertices; i++) {
            System.out.println(sortedPath.pop());
        }
    }

    private static void dfs(List<List<Integer>> dag, int node, boolean[] visited, Stack<Integer> sortedPath) {
        visited[node] = true;
        for (int neighbor : dag.get(node)) {
            if (!visited[neighbor]) {
                dfs(dag, neighbor, visited, sortedPath);
            }
        }
        sortedPath.push(node);
    }
}
