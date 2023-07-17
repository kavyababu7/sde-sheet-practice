package sde.sheet.practice.datastructures.graphs;

import java.util.List;

public class DetectCycleDFSDirected {
    public static void main(String[] args) {
        List<List<Integer>> cyclic = GraphInitializer.buildDirectedCyclic();
        int vertices = cyclic.size();
        boolean[] visited = new boolean[cyclic.size()];
        boolean[] path = new boolean[cyclic.size()];
        for (int i = 1; i <= vertices; i++) {
            if (!visited[i]) {
                if (dfs(cyclic, visited, path, i)) {
                    System.out.println("true");
                    break;
                }
            }
        }
    }

    private static boolean dfs(List<List<Integer>> cyclic, boolean[] visited, boolean[] path, int node) {
        visited[node] = true;
        path[node] = true;
        for (int neighbor : cyclic.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(cyclic, visited, path, neighbor)) {
                    return true;
                }
            } else if (path[neighbor]) {
                return true;
            }
        }
        path[node] = false;
        return false;
    }
}
