package sde.sheet.practice.datastructures.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 1, 2, 4, 2, 3};
        int K = 3;
        System.out.println(kMostFrequent(arr, K));
    }

    private static List<Integer> kMostFrequent(int[] arr, int K) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        //put into a map
        for (int i = 0; i < arr.length; i++) {
            frequencyMap.merge(arr[i], 1, Integer::sum);
        }
        //add to pqueue with priority on value
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ?
                        Integer.compare(a.getKey(), b.getKey())
                        :
                        Integer.compare(a.getValue(),b.getValue()));

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(entry);
            if (priorityQueue.size() > K) {
                priorityQueue.poll();
            }
        }
        List<Integer> numbers = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            numbers.add(priorityQueue.poll().getKey());
        }
        return numbers;
    }
}
