package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsInUndirectedGraphDFS {
    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        adjacencyList.add(List.of(1));
        adjacencyList.add(List.of(0,2));
        adjacencyList.add(List.of(1));
        adjacencyList.add(List.of(4));
        adjacencyList.add(List.of(3));
        int count = numberOfConnectedComponents(adjacencyList);
        System.out.println("connected components = " + count);
    }

    private static int numberOfConnectedComponents(List<List<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        int count = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                count++;
                dfs (adjacencyList, visited, -1, i);
            }
        }
        return count;
    }

    private static void dfs(List<List<Integer>> adjacencyList, boolean visited[], int parent, int node) {
        visited[node] = true;
        for (Integer neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs (adjacencyList, visited, node, neighbor);
            }
        }
    }
}
