package sde.sheet.practice.dp.partitions;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(mcm(arr));
    }

    private static int mcm(int[] arr) {
        int i = 1;
        int j = arr.length - 1;
        int[][] dp = new int[j + 1][j + 1];
        for (int[] dpArr : dp) {
            Arrays.fill(dpArr, -1);
        }
        return mcm(arr, i, j, dp);
    }

    private static int mcm(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minim = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ways = (arr[i - 1] * arr[k] * arr[j]) + mcm(arr, i, k, dp) + mcm(arr, k + 1, j, dp);
            minim = Math.min(ways, minim);
        }
        dp[i][j] = minim;
        return minim;
    }
}
