package sde.sheet.practice.dp;

import java.util.stream.IntStream;

class SubsetSum {

    public static void main(String[] args) {
        int[] nums = {9};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int target = IntStream.of(nums).sum();
        int len = nums.length;
        boolean[][] dp = new boolean[len+1][target+1];
        if (len < 2) {
            return false;
        }
        if (target % 2 != 0) {
            return false;
        }
        target = target/2;
        for (boolean[] dpArr: dp) {
            dpArr[0] = true;
        }
        dp[0][nums[0]] = true;
        for (int index = 1; index < len; index++) {
            for (int sum = 1; sum <= target; sum++) {
                boolean take = false;
                if (sum-nums[index] >= 0) {
                    take = dp[index-1][sum-nums[index]] ;
                }
                boolean notTake = dp[index-1][sum] ;
                dp[index][sum] = take||notTake;                
            }
        }       
       return dp[nums.length-1][target];
    }
}