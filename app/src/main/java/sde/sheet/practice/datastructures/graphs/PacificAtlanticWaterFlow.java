package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            dfs(heights, pacific, row, 0, heights[row][0]);
            dfs(heights, atlantic, row, cols-1, heights[row][cols-1]);
        }

        for (int col = 0; col < cols; col++) {
            dfs(heights, pacific, 0, col, heights[0][col]);
            dfs(heights, atlantic, rows-1, col, heights[rows-1][col]);
        }
        List<List<Integer>> result = new ArrayList();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] heights, boolean[][] visited, int r, int c, int previousHeight) {
        int rows = heights.length;
        int cols = heights[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || previousHeight > heights[r][c]){
            return;
        }
        visited[r][c] = true;
        dfs(heights, visited, r-1, c, heights[r][c]);
        dfs(heights, visited, r+1, c, heights[r][c]);
        dfs(heights, visited, r, c+1, heights[r][c]);
        dfs(heights, visited, r, c-1, heights[r][c]);
    }
}
