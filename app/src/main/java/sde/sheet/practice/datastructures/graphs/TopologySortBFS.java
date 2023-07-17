package sde.sheet.practice.datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologySortBFS {
    public static void main(String[] args) {
        List<List<Integer>> dag = GraphInitializer.buildDAG();
        bfs(dag);

    }

    private static void bfs(List<List<Integer>> dag) {
        int size = dag.size();
        int[] indegree = new int[size];
        //find indegree
        for (int i = 0; i < size; i++) {
            for (int neighbor : dag.get(i)) {
                indegree[neighbor]++;
            }
        }
        //put anything of 0 indegree to queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] topSort = new int[size];
        int index = 0;
        //bfs
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            topSort[index++] = node;
            for (int neighbor: dag.get(node)) {
                //reduce the indegree on visiting each node
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println(Arrays.toString(topSort));

    }
}
