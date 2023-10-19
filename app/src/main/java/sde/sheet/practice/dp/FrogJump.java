package sde.sheet.practice.dp;

import java.util.*;

public class FrogJump {

    public static void main(String[] args) {
        int[] arr = {30,20,60,10,60,50};
        int energy = minEnergy(arr, arr.length-1);
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int energyMemoisation = minEnergyMemo(arr, arr.length-1, dp);
        System.out.println(energy);
        System.out.println(energyMemoisation);
    }

    private static int minEnergy(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        int left = minEnergy(arr, n-1) + Math.abs(arr[n-1]-arr[n]);
        int right = n-2 >= 0 ? minEnergy(arr, n-2) + Math.abs(arr[n-2]-arr[n]) : Integer.MAX_VALUE;
        return Math.min(left, right);
    }

    private static int minEnergyMemo(int[] arr, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) return dp[n];
        int left = minEnergy(arr, n-1) + Math.abs(arr[n-1]-arr[n]);
        int right = n-2 >= 0 ? minEnergy(arr, n-2) + Math.abs(arr[n-2]-arr[n]) : Integer.MAX_VALUE;
        dp[n] = Math.min(left, right);
        return dp[n];
    }
}
