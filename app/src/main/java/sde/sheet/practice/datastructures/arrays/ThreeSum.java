package sde.sheet.practice.datastructures.arrays;

import sde.sheet.practice.datastructures.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int sum = 0;
        Set<List<Integer>> sumsBrute = threeSumBrute(arr, sum);
        Set<List<Integer>> sumsBetter = threeSumBetter(arr, sum);
        List<List<Integer>> sumsOptimized = threeSumOptimized(arr, sum);
    }

    private static List<List<Integer>> threeSumOptimized(int[] arr, int num) {
        List<List<Integer>> combos = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            int low = i+1;
            int high = arr.length - 1;
            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];
                if (sum > 0) {
                    high --;
                } else if (sum < 0) {
                    low ++;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[low], arr[high]);
                    Collections.sort(temp);
                    combos.add(temp);
                    high--;
                    low++;
                    while (high > low && arr[high+1] == arr[high]) high--;
                    while (high > low && arr[low-1] == arr[low]) low++;
                }
            }
        }
        return combos;
    }

    private static Set<List<Integer>> threeSumBetter(int[] arr, int sum) {
        Set<List<Integer>> combos = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> compliSet = new HashSet<>();
            for (int j = i+1; j < arr.length; j++) {
                int compliment = - (arr[i] + arr[j]);
                if (compliSet.contains(compliment)) {
                    List<Integer> numbers = Arrays.asList(arr[i], arr[j], compliment);
                    Collections.sort(numbers);
                    combos.add(numbers);
                }
                compliSet.add(arr[j]);
            }
        }
        return combos;
    }

    private static Set<List<Integer>> threeSumBrute(int[] arr, int sum) {
        Set<List<Integer>> numbers = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        List<Integer> tmp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(tmp);
                        numbers.add(tmp);
                    }
                }
            }
        }
        return numbers;
    }
}
