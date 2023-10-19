package sde.sheet.practice.datastructures.arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] prices = {1, 1, 0, 1, 1, 1};
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == 0) {
                count = 0;
            } else {
                count++;
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(maxCount);
    }
}
