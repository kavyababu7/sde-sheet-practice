package sde.sheet.practice.datastructures.arrays;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        int duplicate1 = brute(Arrays.copyOf(arr, arr.length));
        System.out.println(duplicate1);

        int duplicate2 = frequencyBased(arr);
        System.out.println(duplicate2);

        int duplicate3 = linkedListBased(arr);
        System.out.println(duplicate3);
    }

    //O(n)
    private static int linkedListBased(int[] arr) {

        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        fast = arr[0];
        while (slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    //O(n)
    private static int frequencyBased(int[] arr) {
        int[] freqArr = new int[arr.length];
//        Arrays.fill(freqArr, 0);
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            freqArr[index]++;
            if (freqArr[index] == 2) {
                return index;
            }
        }
        return 0;
    }

    //O(n2)
    private static int brute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i+1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
