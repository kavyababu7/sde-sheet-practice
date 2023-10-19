package sde.sheet.practice.recursion;

import java.util.ArrayList;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        ArrayList<Integer> sums = new ArrayList<>();
        subsetSums(0, arr, 0, sums);
        System.out.println(sums);
    }

    private static void subsetSums(int index, int[] arr, int sum, ArrayList<Integer> sums) {
        if (arr.length == index) {
            sums.add(sum);
            return;
        }
        subsetSums(index+1, arr, sum+arr[index], sums);
        subsetSums(index+1, arr, sum, sums);
    }
}
