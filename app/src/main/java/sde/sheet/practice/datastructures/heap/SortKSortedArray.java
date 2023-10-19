package sde.sheet.practice.datastructures.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        List<Integer> elements = kthLargestElement(arr, k);
        System.out.println(elements);
    }

    private static List<Integer> kthLargestElement(int[] arr, int k) {
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            if (heap.size() > k) {
                sortedList.add(heap.poll());
            }
        }
        while (!heap.isEmpty()) {
            sortedList.add(heap.poll());
        }
        return sortedList;
    }
}
