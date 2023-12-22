package sde.sheet.practice.dp.partitions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {
    public static void main(String[] args) {
        System.out.println(maxCoinsTabulation(new int[]{3,1,5,8}));
    }

    public static int maxCoinsTabulation(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numList.add(0, 1);
        numList.add(1);
        int len = nums.length;
        int[][] dp = new int[len+2][len+2];
        for (int i = 0; i < len+1; i++) {
            for (int j = 0; j < len+1; j++) {
                if (i > j) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int start = len; start >= 1; start--) {
            for (int end = 1; end <= len; end++) {
                if (start > end) continue;
                int maxCost = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    int cost = (numList.get(start-1) * numList.get(i) * numList.get(end+1))
                            + dp[start][i-1]
                            + dp[i+1][end];
                    maxCost = Math.max(maxCost, cost);
                }
                dp[start][end] = maxCost;
            }
        }
        return dp[1][len];
    }

    public int maxCoins(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numList.add(0, 1);
        numList.add(1);
        int[][] dp = new int[numList.size()][numList.size()];
        for (int[] dpArr: dp) {
            Arrays.fill(dpArr, -1);
        }
        return maxCostToBurst(numList, 1, nums.length, dp);
    }

    private int maxCostToBurst(List<Integer> nums, int start, int end, int[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int maxCost = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int cost = (nums.get(start-1) * nums.get(i) * nums.get(end+1))
                    + maxCostToBurst(nums, start, i-1, dp)
                    + maxCostToBurst(nums, i+1, end, dp);
            maxCost = Math.max(maxCost, cost);
        }
        dp[start][end] = maxCost;
        return maxCost;
    }
}
