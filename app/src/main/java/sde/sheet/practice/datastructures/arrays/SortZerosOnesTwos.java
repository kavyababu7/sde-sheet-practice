package sde.sheet.practice.datastructures.arrays;

import java.util.Arrays;

public class SortZerosOnesTwos {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] optimalArr = optimal(nums);
        System.out.println(Arrays.toString(optimalArr));
        int[] bestArr = best(nums);
        System.out.println(Arrays.toString(bestArr));
    }

    private static int[] best(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        int mid = 0;
        int high = nums.length-1;
        int low = 0;
        while (mid<=high) {
            if (sorted[mid] == 0) {
                int temp = sorted[mid];
                sorted[mid] = sorted[low];
                sorted[low] = temp;
                mid++;low++;
            } else if (sorted[mid] == 1) {
                mid++;
            } else {
                int temp = sorted[mid];
                sorted[mid] = sorted[high];
                sorted[high] = temp;
                mid++;high--;
            }
        }
        return sorted;
    }

    private static int[] optimal(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            }
        }
        int[] sorted = new int[nums.length];
        Arrays.fill(sorted, 0, count0, 0);
        Arrays.fill(sorted, count0, count0+count1, 1);
        Arrays.fill(sorted, count0+count1, nums.length, 2);
        return sorted;
    }
}
