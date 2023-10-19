package sde.sheet.practice.datastructures.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestNumbers {
    public static void main(String[] args) {
        int k = 7;
        int[] arr = {5, 6, 7, 8, 9};
        int[] nums = kClosest(arr, k, 3);
        kClosestWithoutComparable(arr, 3, k);
    }

    private static int[] kClosest(int[] arr, int k, int m) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pairs.add(new Pair(Math.abs(arr[i] - k), arr[i]));
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (Pair pair : pairs) {
            heap.add(pair);
            if (heap.size() > m) {
                heap.poll();
            }
        }
        int[] nums = new int[m];
        int i = 0;
        while (!heap.isEmpty()) {
            nums[i] = heap.poll().value;
            i++;
        }
        return nums;
    }

    private static void kClosestWithoutComparable(int[] arr, int k, int m) {
        List<IntPair> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            pairs.add(new IntPair(Math.abs(arr[i] - m), arr[i]));
        }
        PriorityQueue<IntPair> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.diff == b.diff) {
                return b.value - a.value;
            } else {
                return b.diff - a.diff;
            }
        });
        for (IntPair pair : pairs) {
            priorityQueue.add(pair);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().value);
        }
    }
}

class IntPair {
    public int value;
    public int diff;

    public IntPair(int diff, int value) {
        this.diff = diff;
        this.value = value;
    }
}
