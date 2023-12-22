package sde.sheet.practice.binarysearch;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class AllocateMaxPages {
    public static void main(String[] args) {
        int n = 4;
        int[] arr= {25, 46, 28, 49, 24};
//        int[] arr= {12, 34, 67, 90};
        int maxPageAlloc = getMaxPages(arr, n);
        System.out.println(maxPageAlloc);
    }

    private static int getMaxPages (int[] arr, int n) {
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(arr).summaryStatistics();
        int low = intSummaryStatistics.getMax();
        int high = (int)intSummaryStatistics.getSum();
        while (high >= low) {
            int mid = (high + low)/2;
            int numOfStudents = numberOfStudents(mid, arr);
            if (numOfStudents > n) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    private static int numberOfStudents(int sum, int[] arr) {
        int pageSum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (pageSum > sum) {
                count++;
                pageSum = arr[i];
            } else {
                pageSum += arr[i];
            }
        }
        return count;
    }
}
