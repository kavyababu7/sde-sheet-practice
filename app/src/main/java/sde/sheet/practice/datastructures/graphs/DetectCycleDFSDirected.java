package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDFSDirected {
    public static void main(String[] args) {
        List<List<Integer>> cyclic = new ArrayList<>();
//        cyclic.add()

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

    private static boolean dfs(List<List<Integer>> cyclic, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbor : cyclic.get(node)) {
            if (!visited[neighbor]) {
                return dfs(cyclic, visited, pathVisited, neighbor);
            } else if (pathVisited[neighbor]) {
                    return false;
            }
        }
        pathVisited[node] = false;
        return true;
    }
}
