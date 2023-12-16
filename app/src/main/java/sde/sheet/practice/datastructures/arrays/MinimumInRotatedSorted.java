package sde.sheet.practice.datastructures.arrays;

public class MinimumInRotatedSorted {

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5, 6, 7, 8, 1, 2};
//        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        int[] nums = {2,1};

        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int mid = (start + end)/2;
            //is pivot in left
            if (nums[mid] <= nums[end]) {
                end = mid;
                min = Math.min(min, nums[end]);
            } else { //right sorted
                start = mid+1;
                min = Math.min(min, nums[start]);
            }
        }
        return min;
    }
}
