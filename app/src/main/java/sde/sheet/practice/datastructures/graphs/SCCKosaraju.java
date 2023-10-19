package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SCCKosaraju {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}};
        //convert to adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        System.out.println(adj);
        System.out.println(countScc(adj, n));
    }

    private static int countScc(List<List<Integer>> adj, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[adj.size()];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(adj, i, stack, visited);
            }
        }
        //reverse edges
        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            for (int neighbor: adj.get(i)) {
                adjT.get(neighbor).add(i);
            }
        }
        System.out.println(stack);
        int sccCounter = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (visited[node] == 0) {
                sccCounter++;
                dfs (adjT, node, visited);
            }
        }
        return sccCounter;
    }

    private static void dfs(List<List<Integer>> adj, Integer node, int[] visited) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(adj, neighbor, visited);
            }
        }
    }

    private static void dfs(List<List<Integer>> adj, int node, Stack<Integer> stack, int[] visited) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(adj, neighbor, stack, visited);
            }
        }
        stack.push(node);
    }
}
