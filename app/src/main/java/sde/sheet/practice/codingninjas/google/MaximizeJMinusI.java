package sde.sheet.practice.codingninjas.google;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximizeJMinusI {
    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 8, 9, 10, 4, 5, 6};
        int diff1 = maximiseDiffOfIndexBruteForce(arr);
        int diff3 = maximiseDiffOfIndexEfficient(arr);
        int diff2 = maximiseDiffOfIndexOptimized(arr);
    }

    private static int maximiseDiffOfIndexOptimized(int[] arr) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            numIndexMap.put(arr[i], i);
        }
        Arrays.sort(arr);
        int maxDiff = Integer.MIN_VALUE;
        int temp = n;
        for (int i = 0; i < n; i++) {
            if (temp > numIndexMap.get(arr[i])) {
                temp = numIndexMap.get(arr[i]);
            }
            maxDiff = Math.max(maxDiff, numIndexMap.get(arr[i])-temp);
        }
        return maxDiff;
    }

    private static int maximiseDiffOfIndexBruteForce(int[] arr) {
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[i] < arr[j]) {
                    maxDiff = Math.max(maxDiff, j-i);
                }
            }
        }
        return maxDiff;
    }


    private static int maximiseDiffOfIndexEfficient(int[] arr) {
        int n = arr.length;
        int[] lMin = new int[n];
        int[] rMax = new int[n];
        lMin[0] = arr[0];
        rMax[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(lMin[i - 1], arr[i]);
            rMax[n - i - 1] = Math.max(rMax[n - i], arr[n - i - 1]);
        }
        int maxDiff = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (lMin[i] <= rMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                maxDiff = Math.max(maxDiff, j - i);
                i++;
            }
        }
        return maxDiff;
    }
}
