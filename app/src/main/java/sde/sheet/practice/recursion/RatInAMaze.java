package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        List<String> paths = new ArrayList<>();
        int[][] vis = new int[m.length][m[0].length];
        vis[0][0] = 1;
        int[] cordX = {-1, 0, 1, 0};
        int[] cordY = {0, -1, 0, 1};
        travel(m, 0, 0, paths, "", vis, cordX, cordY);
        System.out.println(paths);
    }

    private static void travel(int[][] m, int row, int col, List<String> paths, String temp, int[][] vis, int[] cordX, int[] cordY) {
        if (row == m.length - 1 && col == m[0].length - 1) {
            paths.add(temp);
            return;
        }
        String dir = "ULDR";
        for (int i = 0; i < 4; i++) {
            int x = row + cordX[i];
            int y = col + cordY[i];
            if (x >= 0 && x < m.length && y >= 0 && y < m[0].length && vis[x][y] == 0 && m[x][y] != 0) {
                vis[x][y] = 1;
                travel(m, x, y, paths, temp+dir.charAt(i), vis, cordX, cordY);
                vis[x][y] = 0;
            }
        }

    }
}
