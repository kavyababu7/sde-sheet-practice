package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

public class BellmanFord {
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        List<List<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<>(Arrays.asList(2, 4, 3)));
            }
        };

        int[] dist = getShortestPaths(edges, S, V);
        System.out.println(Arrays.toString(dist));
    }

    private static int[] getShortestPaths(List<List<Integer>> edges, int s, int v) {
        int[] dist = new int[edges.size() - 1];
        Arrays.fill(dist, MAX_VALUE);
        dist[s] = 0;
        for (int i = 0; i < v - 1; i++) {
            for (List<Integer> edge : edges) {
                int a = edge.get(0);
                int b = edge.get(1);
                int wt = edge.get(2);
                if (dist[a] != MAX_VALUE && dist[b] > dist[a] + wt) {
                    dist[b] = dist[a] + wt;
                }
            }
        }
        for (List<Integer> edge : edges) {
            Integer a = edge.get(0);
            Integer b = edge.get(1);
            Integer wt = edge.get(2);
            if (dist[a] != MAX_VALUE && dist[b] > dist[a] + wt) {
                return new int[]{-1};
            }
        }

        return dist;
    }
}
