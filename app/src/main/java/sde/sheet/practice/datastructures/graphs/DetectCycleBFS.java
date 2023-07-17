package sde.sheet.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleBFS {
    public static void main(String[] args) {
        List<List<Integer>> adjacency = GraphInitializer.buildCyclic();
        boolean[] visited = new boolean[adjacency.size()];
        System.out.println(detectCycle(adjacency, 1, visited));
        adjacency = GraphInitializer.buildType1();
        visited = new boolean[adjacency.size()];
        System.out.println(detectCycle(adjacency, 1, visited));
        adjacency = GraphInitializer.buildDisconnected();
        System.out.println(detectCycleInComponent(adjacency));
        adjacency = GraphInitializer.buildDisconnectedCycle();
        System.out.println(detectCycleInComponent(adjacency));
    }

    private static boolean detectCycle(List<List<Integer>> adjacency, int startingIndex, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startingIndex, -1));
        visited[startingIndex] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int node = pair.node;
            int parent = pair.parent;
            for (int neighbor : adjacency.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new Pair(neighbor, node));
                    //if a neighbor is visited and it is not coming as a parent node, it was visited by someone else
                } else if (parent != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean detectCycleInComponent(List<List<Integer>> adjacency) {
        boolean[] visited = new boolean[adjacency.size()];
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                if (detectCycle(adjacency, i, visited)) return true;
            }
        }
        return false;
    }

}