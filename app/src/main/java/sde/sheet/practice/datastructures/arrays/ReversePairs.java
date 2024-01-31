package sde.sheet.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

class ReversePairs {
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(count);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high+low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
    }

    private static void merge (int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> temp = new ArrayList();
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i-low);
        }
    }

    private static int countPairs(int nums[], int low, int mid, int high) {
        int right = mid+1;
        int cnt = 0;
        for (int i  = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2*nums[right]) right++;
            cnt += right - (mid+1);
        }
        System.out.println(low + ":" + high + "->" + cnt);
        return cnt;
    }
}