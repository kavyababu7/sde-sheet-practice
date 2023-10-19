package sde.sheet.practice.dp;

public class FrogJumpKDistance {
    public static void main(String[] args) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        int energy = minEnergy(height, n, k);
    }

    private static int minEnergy(int[] height, int n, int k) {
        if (n <= 1)
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        int minEnergy = Integer.MAX_VALUE;
        int totalEnergy = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 1; j <= k; j++) {
                int val = i - j >= 0 ? dp[i-j] + Math.abs(height[i - j] - height[i]) : Integer.MAX_VALUE;
                minEnergy = Math.min(minEnergy, val);
            }
            totalEnergy += minEnergy;
        }
        return totalEnergy;

    }
}
