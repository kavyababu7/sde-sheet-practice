package sde.sheet.practice.datastructures.graphs;

import java.util.List;

public class ProvinceCounter {
    public static void main(String[] args) {
        List<List<Integer>> adjList = GraphInitializer.buildDisconnected();
        boolean[] visited = new boolean[adjList.size()];
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adjList, visited);
            }
        }
        System.out.println("Number of provinces = " + count);
    }
    // SC = O(n) + O(n)

    private static void dfs(int startingNode, List<List<Integer>> adjList, boolean[] visited) {
        visited[startingNode] = true;
        for (int neighbour : adjList.get(startingNode)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited);
            }
        }
    }
}
