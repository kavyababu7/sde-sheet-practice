package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumDup {
    public static void main(String[] args) {
        int K = 6;
        int[] arr = {1, 1, 2, 1};
        Set<String> answers = new HashSet<>();
        List<Integer> interArray = new ArrayList<>();
        subsequenceOfSumKDup(arr, K, 0, interArray, answers);
        System.out.println(answers);
    }

    private static void subsequenceOfSumKDup(int[] arr, int K, int index, List<Integer> interArray, Set<String> answers) {
        if (arr.length == index+1) {
            if (K == 0) {
                Collections.sort(interArray);
                answers.add(interArray.toString());
            }
            return;
        }
        if (arr[index] <= K) {
            interArray.add(arr[index]);
            subsequenceOfSumKDup(arr, K-arr[index], index, interArray, answers);
            interArray.remove(interArray.size() - 1);
        }
        subsequenceOfSumKDup(arr, K, index + 1, interArray, answers);
    }

    private static void subsequenceOfSumKDupOptimized(int[] arr, int K, int index, List<Integer> interArray, Set<String> answers) {
        if (arr.length == index+1) {
            if (K == 0) {
                Collections.sort(interArray);
                answers.add(interArray.toString());
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //if ()
            if (i > index && arr[i] == arr[i-1]) {
                continue;
            }
        }
    }
}
