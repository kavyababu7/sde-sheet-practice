package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetNoDuplicate {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        Set<String> sums = new HashSet<>();
        subsets(0, arr, new ArrayList<>(), sums);
        System.out.println(sums);
    }

    private static void subsets(int index, int[] arr, List<Integer> subset,  Set<String> subsets) {
        if (arr.length == index) {
            Collections.sort(subset);
            subsets.add(subset.toString());
            return;
        }
        subset.add(arr[index]);
        subsets(index + 1, arr, subset, subsets);
        subset.remove(subset.size() - 1);
        subsets(index+1, arr, subset, subsets);
    }
}
