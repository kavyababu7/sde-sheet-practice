package sde.sheet.practice.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementHalf {
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2, 3};
        System.out.println(majorityElementByBrute(nums));
        System.out.println(majorityElementByHashing(nums));
        System.out.println(majorityElementByVoting(nums));
    }

    private static int majorityElementByVoting(int[] nums) {
        int count = 0;
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
            } else {
                if (count == 0) {
                    element = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return element;
    }

    private static int majorityElementByHashing(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer frequency = frequencyMap.getOrDefault(nums[i], 0);
            frequencyMap.put(nums[i], frequency + 1);
        }
        int majorityElement = Integer.MIN_VALUE;
        int maxFrequency = nums.length/2;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                return entry.getKey();
            }
        }
        return majorityElement;
    }

    private static int majorityElementByBrute(int[] nums) {
        int majorityElement = Integer.MIN_VALUE;
        int maxFrequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int frequency = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    frequency++;
                }
            }
            if (frequency > maxFrequency) {
                majorityElement = nums[i];
            }
        }
        return majorityElement;
    }
}
