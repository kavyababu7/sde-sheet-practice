package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteBFS {
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
        for (int i = 1; i < size; i++) {
            if (colors[i] == -1) {
                if (!bfs(adj, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(List<List<Integer>> adj, int[] colors, int node, int currentColor) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = currentColor;
        while (!queue.isEmpty()) {
            Integer n = queue.remove();
            for (int neighbor: adj.get(n)) {
                if (colors[neighbor] == -1) {
                    queue.add(neighbor);
                    colors[neighbor] = 1 - colors[n];
                }
                if (colors[neighbor] == colors[n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
