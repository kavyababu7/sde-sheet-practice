package sde.sheet.practice.datastructures.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        int k = 3;
        Integer[] arr1 = {4, 7, 9};
        Integer[] arr2 = {3, 6, 10};
        Integer[] arr3 = {2, 5, 8};
        List<Integer[]> arrays = List.of(arr1, arr2, arr3);
        Integer[] output = new Integer[k * arr1.length];
        partition(arrays, 0, 3, output);
    }

    private static Integer[] partition(List<Integer[]> arrays, int start, int end, Integer[] output) {
        if (start == end) {
            return arrays.get(end);
        }

        while (start <= end) {
            int mid = (start + end)/2;
            Integer[] left = partition(arrays, start, mid, output);
            Integer[] right = partition(arrays, mid+1, end, output);
            int leftStart = 3 * (mid - start + 1);
            int rightEnd = 3 * (end - mid);
            merge(left, right, leftStart, rightEnd, output);
        }
        return output;
    }

    private static void merge(Integer[] left, Integer[] right, int leftStart, int rightEnd, Integer[] output) {

    }



}
