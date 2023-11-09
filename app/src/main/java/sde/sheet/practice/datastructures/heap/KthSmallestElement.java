package sde.sheet.practice.datastructures.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {5,2,7,4,1,8};
        int k = 3;
        int element = kthSmallestElement(arr, k);
        System.out.println(element);
    }

    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder()); //Max Heap
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
