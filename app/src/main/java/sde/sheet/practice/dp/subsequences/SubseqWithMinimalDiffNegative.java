package sde.sheet.practice.dp.subsequences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubseqWithMinimalDiffNegative {

    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        //System.out.println(isTargetPresent(nums, nums.length - 1, 6));
        int target = 6;
//        int[][] dp = new int[nums.length][target + 1];
//        for (int[] dpArr : dp) {
//            Arrays.fill(dpArr, -1);
//        }
//        System.out.println(isTargetPresentMemoisation(nums, nums.length - 1, target, dp));
        System.out.println(minimumDifference(nums));
    }

    public static int minimumDifference(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        Set<String> dp = new HashSet();
        for (int i = 0; i < len; i++) {
            dp.add(i+"#"+0);
        }

        dp.add(0 + "#" + nums[0]);

        for (int idx = 1; idx < len; idx++) {
            for (int target = 0; target <= sum; target++) {
                String key1 = (idx - 1) + "#" + target;
                boolean notTake = dp.contains(key1);
                boolean take = false;
                if (nums[idx] <= target) {
                    String key2 = (idx - 1) + "#" + (target - nums[idx]);
                    take = dp.contains(key2);
                }
                if (take||notTake) {
                    String key3 = idx + "#" + target;
                    dp.add(key3);
                }

            }
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum/2; i++) {
            String key = (len - 1) + "-" + i;
            if (dp.contains(key)) {
                minDiff = Math.min(minDiff, Math.abs(sum-i-i));
            }
        }
        return minDiff;
    }
}
