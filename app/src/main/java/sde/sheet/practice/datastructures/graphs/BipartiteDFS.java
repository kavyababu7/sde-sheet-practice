package sde.sheet.practice.datastructures.graphs;

import java.util.*;

public class BipartiteDFS {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of());
        adj.add(List.of(2));//1
        adj.add(List.of(1, 3, 6));//2
        adj.add(List.of(2, 4));//3
        adj.add(List.of(3, 5, 7));//4
        adj.add(List.of(4, 6));//5
        adj.add(List.of(2, 5));//6
        adj.add(List.of(4, 8));//7
        adj.add(List.of(7));//8
        System.out.println(isBipartite(adj));
    }

    private static boolean isBipartite(List<List<Integer>> adj) {
        int size = adj.size();
        int[] colors = new int[size];
        for (int i = 0; i < size; i++) {
            colors[i] = -1;
        }
        for (int i = 0; i < size; i++) {
            if (colors[i] == -1) {
                if (!dfs(adj, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> adj, int[] colors, int node, int currentColor) {
        colors[node] = currentColor;
        for (int neighbor : adj.get(node)) {
            if (colors[neighbor] == -1) {
                if (dfs(adj, colors, neighbor, 1 - currentColor)) {
                    return false;
                }
            } else if (colors[neighbor] == currentColor) {
                return false;
            }
        }
        return true;
    }
}
