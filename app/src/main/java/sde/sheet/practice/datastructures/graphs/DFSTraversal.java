package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> adjMatrix = GraphInitializer.buildType2();
        boolean[] visited = new boolean[adjMatrix.size()+1];
        List<Integer> dfsList = new ArrayList<>();
        int startingNode = 1;
        dfs(adjMatrix, startingNode, visited, dfsList);
        System.out.println(dfsList);
    }

    //TC = O(v) + O(degree)
    //SC = O(n) + O(n) + (O(n) (aux))
    private static void dfs(List<List<Integer>> adjMatrix, int node, boolean[] visited, List<Integer> dfsList) {
        visited[node] = true;
        dfsList.add(node);
        for (int neighbor: adjMatrix.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjMatrix, neighbor, visited, dfsList);
            }
        }
    }
}
