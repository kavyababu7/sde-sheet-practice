package sde.sheet.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        int ways = bruteForce(arr);
        mergeSort(arr, 0, arr.length-1);
        System.out.println(count);
    }

    private static int bruteForce(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (high  <= low) {
            return;
        }
        int mid = (high+low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> tempArr = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempArr.add(arr[left]);
                left++;
            } else {
                count += (mid - left + 1);
                tempArr.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            tempArr.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            tempArr.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tempArr.get(i - low);
        }
    }


}
