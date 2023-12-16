package sde.sheet.practice.dp.subsequences;

import java.util.Arrays;

public class SplitSubseqIntoTwo {
    public static void main(String[] args) {
        int[] nums = {2,3,3,3,4,5,1,1};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2 == 1) {
            return false;
        }
        int len = nums.length;
        int S = sum/2;
        boolean[][] dp = new boolean[len][S+1];
        for (int i = 0; i < nums.length; i ++) {
            dp[i][0] = true;
        }
        //idx == 0 and nums[0] == target
        dp[0][nums[0]] = true;


        for (int idx = 1; idx < nums.length; idx++) {
            for (int target = 0; target <= S; target++) {
                boolean notTake = dp[idx-1][target];
                boolean take = false;
                if (nums[idx] <= target) {
                    take = dp[idx-1][target-nums[idx]];
                }
                dp[idx][target] = take || notTake;
            }
        }
        return dp[nums.length-1][S] == true;
    }
}
