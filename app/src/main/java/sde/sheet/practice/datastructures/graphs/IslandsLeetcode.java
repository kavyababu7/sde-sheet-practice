package sde.sheet.practice.datastructures.graphs;

import java.util.*;

class IslandsLeetcode {

    public static void main(String[] args) {
        char[][] grid1 = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void bfs(char[][] grid, int r, int c, int rows, int cols) {
        Queue<List<Integer>> queue = new LinkedList();
        queue.add(List.of(r,c));
        grid[r][c] = '0';
        while (!queue.isEmpty()) {
            List<Integer> currentNode = queue.poll();
            //get neighbors and mark them as visited
            markNeighbors1(grid, currentNode.get(0), currentNode.get(1), rows, cols, queue);
        }
    }

    private static void markNeighbors1(char[][] grid, int r, int c, int rows, int cols, Queue<List<Integer>> queue) {
//        print(grid, rows, cols);
        if (r > 0 && grid[r-1][c] == '1') {
            grid[r-1][c] = '0';
            queue.add(List.of(r-1, c));
        }
        if (r < rows-1 && grid[r+1][c] == '1') {
            grid[r+1][c] = '0';
            queue.add(List.of(r+1, c));
        }
        if (c > 0 && grid[r][c-1] == '1') {
            grid[r][c-1] = '0';
            queue.add(List.of(r, c-1));
        }
        if (c < cols-1 && grid[r][c+1] == '1') {
            grid[r][c+1] = '0';
            queue.add(List.of(r, c+1));
        }

    }

    private static void print(char[][] grid, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
    }

}
