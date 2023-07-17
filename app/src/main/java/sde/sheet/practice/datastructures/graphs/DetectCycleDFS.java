package sde.sheet.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleDFS {
    public static void main(String[] args) {
        List<List<Integer>> adjacency = GraphInitializer.buildCyclic();
        boolean[] visited = new boolean[adjacency.size()];
        System.out.println(dfs(adjacency, 1, visited));
        adjacency = GraphInitializer.buildType1();
        visited = new boolean[adjacency.size()];
        System.out.println(dfs(adjacency, 1, visited));
        adjacency = GraphInitializer.buildDisconnected();
        System.out.println(detectCycleInComponent(adjacency));
        adjacency = GraphInitializer.buildDisconnectedCycle();
        System.out.println(detectCycleInComponent(adjacency));
    }

    private static boolean dfs(List<List<Integer>> adjacency, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor: adjacency.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(adjacency, neighbor, visited)) {
                    return true;
                }
            } else if (neighbor != node){
                return true;
            }
        }
        return false;
    }


    private static boolean detectCycleInComponent(List<List<Integer>> adjacency) {
        boolean[] visited = new boolean[adjacency.size()];
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                if (dfs(adjacency, i, visited)) return true;
            }
        }
        return false;
    }

}

class Pair {
    int node;
    int parent;

    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}