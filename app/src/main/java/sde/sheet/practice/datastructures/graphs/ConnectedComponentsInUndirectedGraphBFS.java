package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponentsInUndirectedGraphBFS {
    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        adjacencyList.add(List.of(1));
        adjacencyList.add(List.of(0,2));
        adjacencyList.add(List.of(1));
        adjacencyList.add(List.of(4));
        adjacencyList.add(List.of(3));
        int count = numberOfConnectedComponentsBfs(adjacencyList);
        System.out.println("connected components = " + count);
    }

    private static int numberOfConnectedComponentsBfs(List<List<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        int count = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                count++;
                bfs (adjacencyList, visited, i);
            }
        }
        return count;
    }

    private static void bfs(List<List<Integer>> adjacencyList, boolean visited[], int node) {
        Queue<Integer> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            visited[currentNode] = true;
            for (Integer neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor])
                    queue.add(neighbor);
            }
        }
    }
}
