package sde.sheet.practice.dp.strings;

import java.util.Arrays;

public class LongestIncreasingMatrixPath {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] dpArr: dp) {
            Arrays.fill(dpArr, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    dfs(matrix, dp, i, j, m, n, -1);
                }
            }
        }
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    private static int dfs(int[][] matrix, int[][] dp, int i, int j, int l1, int l2, int parent) {
        if (i < 0 || j < 0 || i == l1 || j == l2 || parent >= matrix[i][j]) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int left = dfs(matrix, dp, i, j-1, l1, l2, matrix[i][j]);
        int right = dfs(matrix, dp, i, j+1, l1, l2, matrix[i][j]);
        int top = dfs(matrix, dp, i-1, j, l1, l2, matrix[i][j]);
        int bottom = dfs(matrix, dp, i+1, j, l1, l2, matrix[i][j]);
        int horiz = Math.max(left, right);
        int vert = Math.max(top, bottom);
        dp[i][j] = 1+ Math.max(horiz, vert);
        return dp[i][j];
    }
}
