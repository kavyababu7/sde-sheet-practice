package sde.sheet.practice.datastructures.arrays;

public class MinimumInRotatedSorted {

    public static void main(String[] args) {
        int[] nums = {2,1};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        int min = Integer.MAX_VALUE;
        if (nums.length == 1) {
            return nums[0];
        }
        while (high >= low) {
            int mid = low + (high - low)/2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return min;
    }
}
