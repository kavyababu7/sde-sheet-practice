package sde.sheet.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        boolean[] taken = new boolean[3];
        List<Integer> numbers = new ArrayList<>();
        List<List<Integer>> permutationsList = new ArrayList<>();
        getPermutations(0, arr, taken, numbers, permutationsList);
        System.out.println(permutationsList);
        permutationsList = new ArrayList<>();
        getPermutationsSpaceOptimized(0, arr, permutationsList);
        System.out.println(permutationsList);
    }

    private static void getPermutationsSpaceOptimized(int index, int[] arr, List<List<Integer>> permutationsList) {
        if (index == arr.length){
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                nums.add(arr[i]);
            }
            permutationsList.add(nums);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            getPermutationsSpaceOptimized(index+1, arr, permutationsList);
            swap(arr, index, i);
        }
    }

    private static void swap (int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void getPermutations(int index, int[] arr, boolean[] taken, List<Integer> numbers, List<List<Integer>> permutationsList) {
        if(numbers.size()==arr.length) {
            permutationsList.add(List.copyOf(numbers));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!taken[i]) {
                taken[i] = true;
                numbers.add(arr[i]);
                getPermutations(index+1, arr, taken, numbers, permutationsList);
                taken[i] = false;
                numbers.remove(numbers.size()-1);
            }
        }
    }
}
