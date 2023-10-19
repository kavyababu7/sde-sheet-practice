package sde.sheet.practice.datastructures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int sum = 14;
        boolean isPresentBrute = twoSumBrute(arr, sum);
        boolean isPresentBetter = twoSumBetter(arr, sum);
        boolean isPresentOptimal = twoSumOptimal(arr, sum);
        System.out.println(isPresentBrute);
        System.out.println(isPresentBetter);
        System.out.println(isPresentOptimal);
    }

    private static boolean twoSumOptimal(int[] arr, int sum) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (high > low) {
            if (arr[high] + arr[low] > sum) {
                high --;
            } else if (arr[high] + arr[low] < sum) {
                low++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean twoSumBetter(int[] arr, int sum) {
        Map<Integer, Integer> complimentMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (complimentMap.containsKey(sum - arr[i])) {
                return true;
            }
            complimentMap.put(arr[i], 1);
        }
        return false;
    }

    private static boolean twoSumBrute(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum)
                    return true;
            }
        }
        return false;
    }
}
