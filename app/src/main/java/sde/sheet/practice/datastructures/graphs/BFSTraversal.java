package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
