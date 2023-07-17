package sde.sheet.practice.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCounter {
    public static void main(String[] args) {
        int[][] ocean = {
                         {0, 1, 1, 0},
                         {0, 1, 1, 0},
                         {0, 0, 1, 0},
                         {0, 0, 0, 0},
                         {1, 1, 0, 1}
                        };
        int rows = ocean.length;
        int cols = ocean[0].length;
        //created visited matrix
        int[][] visited = new int[rows][cols];
        int numberOfIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //check if this is a land and is not visited
                if (ocean[i][j] == 1 && visited[i][j] != 1) {
                    bfs(ocean, visited, i, j, rows, cols);
                    numberOfIslands++;
                }
            }
        }
        System.out.println("number of islands = "+ numberOfIslands);
    }

    private static void bfs(int[][] ocean, int[][] visited, int nodeRow, int nodeCol, int rows, int cols) {
        visited[nodeRow][nodeCol] = 1;
        Queue<RowColPair> queue = new LinkedList<>();
        queue.add(new RowColPair(nodeRow, nodeCol));
        while (!queue.isEmpty()) {
            RowColPair rowColPair = queue.remove();
            //find neighbors
            for (int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    int nRow = rowColPair.row+i;
                    int nCol = rowColPair.col+j;
                    if (nRow >= 0 && nRow < rows &&
                        nCol >= 0 && nCol < cols &&
                        ocean[nRow][nCol] != 0 && visited[nRow][nCol] != 1) {
                        visited[nRow][nCol] = 1;
                        queue.add(new RowColPair(nRow, nCol));
                    }
                }
            }
        }
    }


}

class RowColPair {
    int row;
    int col;
    RowColPair (int row, int col) {
        this.row = row;
        this.col = col;
    }
}
