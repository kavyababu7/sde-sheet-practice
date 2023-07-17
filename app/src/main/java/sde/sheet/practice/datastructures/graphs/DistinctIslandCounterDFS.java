package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DistinctIslandCounterDFS {
    public static void main(String[] args) {
        int[][] ocean = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0}
        };
        int rows = ocean.length;
        int cols = ocean[0].length;
        //created visited matrix
        int[][] visited = new int[rows][cols];
        Set<List<String>> distinctIslandList = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //check if this is a land and is not visited
                if (ocean[i][j] == 1 && visited[i][j] != 1) {
                    List<String> islandPath = new ArrayList<>();
                    dfs(ocean, visited, i, j, rows, cols, islandPath);
                    distinctIslandList.add(islandPath);
                }
            }
        }
        System.out.println("number of islands = " + distinctIslandList.size());
    }

    private static void dfs(int[][] grid, int[][] visited, int nodeRow, int nodeCol, int rows, int cols, List<String> islandPath) {
        visited[nodeRow][nodeCol] = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborRow = nodeRow + i;
                int neighborCol = nodeCol + j;
                if (neighborRow >= 0 && neighborRow < rows &&
                        neighborCol >= 0 && neighborCol < cols &&
                        grid[neighborRow][neighborCol] == 1 && visited[neighborRow][neighborCol] != 1) {
                    visited[neighborRow][neighborCol] = 1;
                    islandPath.add((neighborRow-nodeRow)+":"+(neighborCol-nodeCol));
                    dfs(grid, visited, neighborRow, neighborCol, rows, cols, islandPath);
                }

            }
        }
    }


}