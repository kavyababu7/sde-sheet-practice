package sde.sheet.practice.datastructures.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 4, 8, 10}; //0 1 2 3
        int arr2[] = {2, 3, 9}; // 4 5 6
        //usingExtraSpace(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        withoutUsingExtraSpace(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void withoutUsingExtraSpace(int[] arr1, int[] arr2) {
        int n = arr2.length;
        int m = arr1.length;
        int left = m-1;
        int right = 0;
        while (left >= 0 && right < n) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    private static void usingExtraSpace(int[] arr1, int[] arr2) {
        int n = arr2.length;
        int m = arr1.length;
        int[] merged = new int[m + n];
        int left = 0;
        int right = 0;
        int index = 0;
        while (left < m && right < n) {
            if (arr1[left] <= arr2[right]) {
                merged[index] = arr1[left];
                left ++;
            } else {
                merged[index] = arr2[right];
                right++;
            }
            index++;
        }
        while (left < m) {
            merged[index++] = arr1[left++];
        }

        while (right < n) {
            merged[index++] = arr2[right++];
        }
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                arr1[i] = merged[i];
            } else {
                arr2[i - m] = merged[i];
            }
        }
    }
}
