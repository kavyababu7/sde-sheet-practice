package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class DijkstraQ {
    public static void main(String[] args) {
        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        List<List<DjPair>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new DjPair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new DjPair(edges[i][2], edges[i][0]));
        }
        System.out.println(Arrays.toString(shortestPaths(adj, 1)));


    }

    private static int[] shortestPaths(List<List<DjPair>> adj, int startingNode) {
        //initialize pq
        Queue<DjPair> priorityQueue = new LinkedList<>();
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        priorityQueue.add(new DjPair(0, startingNode));
        dist[startingNode] = 0;
        while (!priorityQueue.isEmpty()) {
            DjPair pair = priorityQueue.poll();
            int distance = pair.distance;
            int node = pair.node;
            for (DjPair neighbor : adj.get(node)) {
                int delta = neighbor.distance + distance;
                if (delta < dist[neighbor.node]) {
                    dist[neighbor.node] = delta;
                    priorityQueue.add(new DjPair(delta, neighbor.node));
                }
            }
        }
        return dist;
    }
}
