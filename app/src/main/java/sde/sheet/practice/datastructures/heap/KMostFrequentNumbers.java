package sde.sheet.practice.datastructures.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KMostFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 1, 2, 4, 2, 3};
        int K = 3;
        System.out.println(kMostFrequent(arr, K));
    }

    public static int[] kMostFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap();
        for (int num: nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        nums=new int[]{1};
        List<Integer>[] bucketList = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (bucketList[entry.getValue()] == null) {
                bucketList[entry.getValue()] = new ArrayList();
            }
            bucketList[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        for (int i  = nums.length; i > 0 && k > 0; i--) {
            if (bucketList[i] != null) {
                int size = result.length;
                for (int elem: bucketList[i]) {
                    if (k <= 0) {
                        break;
                    }
                    result[size-k] = elem;
                    k--;
                }
            }
        }
        return result;
    }

    private static void addToResult(int[] result, List<Integer> bucketList, int k) {
        int size = result.length;
        for (int num: bucketList) {
            if (k <= 0) {
                break;
            }
            result[size-k] = num;
            k--;
        }
    }
}
