package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import java.util.Queue;
import java.util.stream.Collectors;

public class BFSTraversal {
    public static void main(String[] args) {
        List<List<Integer>> adjacencyMatrix = GraphInitializer.buildType1();
        System.out.println(bfs(adjacencyMatrix, 1));
    }

    //TC = O(n) + O(2*edge) [degree]
    //SC = O(3n)
    private static List<Integer> bfs(List<List<Integer>> adjacencyMatrix, int startingNode) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[adjacencyMatrix.size()+1];
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(startingNode);
        vis[startingNode] = true;
        while (!nodeQueue.isEmpty()) {
            Integer node = nodeQueue.remove();
            bfs.add(node);
            List<Integer> neighbours = adjacencyMatrix.get(node);
            for (int neighbour: neighbours) {
                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    nodeQueue.add(neighbour);
                }
            }
        }
        return bfs;
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        boolean[] visited = new boolean[edges.size()];
        int node = 0;
        Map<Integer, ArrayList<Integer>> dfsList = new HashMap();
        dfs(edges, v, node, visited, dfsList);
        return (ArrayList<ArrayList<Integer>>) dfsList.values().stream().collect(Collectors.toList());

    }

    private static void dfs (
            ArrayList<ArrayList<Integer>> edge,
            int v, int node, boolean[] visited,
            Map<Integer, ArrayList<Integer>> dfsList) {
        visited[node] = true;
        dfsList.computeIfAbsent(node, k -> new ArrayList()).add(node);
        for (Integer neighbor : edge.get(node)) {
            if (!visited[neighbor]) {
                dfsList.computeIfAbsent(node, k -> new ArrayList()).add(neighbor);
                dfs(edge, v, neighbor, visited, dfsList);
            }
        }
    }
}
