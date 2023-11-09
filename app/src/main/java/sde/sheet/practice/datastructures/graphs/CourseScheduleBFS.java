package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleBFS {

    public static void main(String[] args) {
//        int[][] courses = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
//        int numCourses = 7;
        int[][] courses = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 1}, {13, 1}, {15, 1}, {17, 4}};
        int numCourses = 20;
//        int[][] courses = {{2,3},{3,2}};
//        int numCourses = 4;
        System.out.println(canFinish(numCourses, courses));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 1) {
            return prerequisites[0][0] != prerequisites[0][1];
        }
        Map<Integer, List<Integer>> courseGraph = buildGraph(prerequisites);
        boolean[] visited = new boolean[numCourses + 1];
        boolean[] pVisited = new boolean[numCourses + 1];
        for (int i = 0; i <= numCourses; i++) {
            if (!visited[i] && cyclic(courseGraph, numCourses)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap();
        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList()).add(edge[1]);
        }
        return adjMap;
    }

    private static boolean cyclic(Map<Integer, List<Integer>> prerequisites, int numCourses) {
        int[] indegree = new int[numCourses + 1];
        for (Map.Entry<Integer, List<Integer>> entry:prerequisites.entrySet()) {
            for (int neighbor : entry.getValue()) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : prerequisites.keySet()) {
            if (indegree[key] == 0) {
                queue.add(key);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer currentItem = queue.poll();
            topo.add(currentItem);
            for (Integer neighbor : prerequisites.keySet()) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    topo.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return topo.size() == numCourses;
    }
}
