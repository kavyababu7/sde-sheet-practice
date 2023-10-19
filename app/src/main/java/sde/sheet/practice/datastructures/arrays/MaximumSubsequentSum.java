package sde.sheet.practice.datastructures.arrays;

public class MaximumSubsequentSum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("brute= "+ brute(arr));
        System.out.println("better= "+ better(arr));
        System.out.println("best= "+ best(arr));
    }

    private static int best(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (sum < 0) {
                sum = 0;
            } else {
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    private static int better(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    private static int brute(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum+=arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
