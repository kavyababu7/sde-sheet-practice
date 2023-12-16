package sde.sheet.practice.dp.subsequences;

import java.util.Arrays;

public class SubseqWithTarget {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        //System.out.println(isTargetPresent(nums, nums.length - 1, 6));
        int target = 6;
//        int[][] dp = new int[nums.length][target + 1];
//        for (int[] dpArr : dp) {
//            Arrays.fill(dpArr, -1);
//        }
//        System.out.println(isTargetPresentMemoisation(nums, nums.length - 1, target, dp));
        System.out.println(isTargetPresentTabulation(nums, target));
    }

    private static boolean isTargetPresent(int[] nums, int idx, int target) {
        if (target == 0) {
            return true;
        }
        if (idx == 0) {
            if (nums[idx] == target) {
                return true;
            }
            return false;
        }

        boolean take = false;
        if (nums[idx] <= target) {
            take = isTargetPresent(nums, idx - 1, target - nums[idx]);
        }
        boolean notTake = isTargetPresent(nums, idx - 1, target);
        return take || notTake;
    }

    private static boolean isTargetPresentMemoisation(int[] nums, int idx, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (idx == 0) {
            if (nums[idx] == target) {
                return true;
            }
            return false;
        }

        if (dp[idx][target] != -1) {
            return true;
        }

        boolean take = false;
        if (nums[idx] <= target) {
            take = isTargetPresent(nums, idx - 1, target - nums[idx]);
        }
        boolean notTake = isTargetPresent(nums, idx - 1, target);
        dp[idx][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }

    private static boolean isTargetPresentTabulation(int[] nums, int S) {
        boolean[][] dp = new boolean[nums.length][S + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int idx = 1; idx < nums.length; idx++) {
            for (int target = 0; target <= S; target++) {
                boolean take = false;
                if (nums[idx] <= target) {
                    take =dp[idx - 1][target - nums[idx]];
                }
                boolean notTake = dp[idx - 1][target];
                dp[idx][target] = take || notTake;
            }
        }
        return dp[nums.length-1][S];
    }
}
