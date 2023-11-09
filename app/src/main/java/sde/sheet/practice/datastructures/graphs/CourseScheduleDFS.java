package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleDFS {

    public static void main(String[] args) {
//        int[][] courses = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
//        int[][] courses = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
//        int numCourses = 7;
        int[][] courses = {{0,10},{3,18},{5,5},{6,11},{11,1},{13,1},{15,1},{17,4}};
        int numCourses = 20;
//        int numCourses = 4;
//        int[][] courses = {{2,3},{3,2}};
        System.out.println(canFinish(numCourses, courses));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 1) {
            return prerequisites[0][0] != prerequisites[0][1];
        }
        Map<Integer, List<Integer>>  courseGraph = buildGraph(prerequisites);
        boolean[] visited = new boolean[numCourses+1];
        boolean[] pVisited = new boolean[numCourses+1];
        for (int i = 0; i <= numCourses; i++) {
            if (!visited[i] && cyclic(courseGraph, visited, pVisited, i, len)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap();
        for(int[] edge: edges) {
            adjMap.computeIfAbsent(edge[0], k-> new ArrayList()).add(edge[1]);
        }
        return adjMap;
    }

    private static boolean cyclic(Map<Integer, List<Integer>> prerequisites, boolean[] visited, boolean[] pvisited, int node, int size) {
        if (prerequisites.containsKey(node)) {
            pvisited[node] = true;

            visited[node] = true;
            for (int neighbor : prerequisites.get(node)) {
                if (!visited[neighbor]) {
                    if (cyclic(prerequisites, visited, pvisited, neighbor, size)) {
                        return true;
                    }
                } else if (pvisited[neighbor]) {
                    return true;
                }
            }
            pvisited[node] = false;
        }
        return false;

    }
}
