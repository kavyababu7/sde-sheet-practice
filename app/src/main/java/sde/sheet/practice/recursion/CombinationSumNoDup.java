package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumNoDup {
    public static void main(String[] args) {
        int K = 7;
        int[] arr = {2,3,6,7};
        List<List<Integer>> answers = new ArrayList<>();
        List<Integer> interArray = new ArrayList<>();
        subsequenceOfSumK(arr, K, 0, interArray, answers, 0);
        System.out.println(answers);
    }

    private static void subsequenceOfSumK(int[] arr, int K, int index, List<Integer> interArray, List<List<Integer>> answers, int sum) {
        if (index == arr.length) {
            if (sum == K) {
                ArrayList<Integer> integers = new ArrayList<>(interArray);
                answers.add(integers);
            }
            return;
        }
        if (arr[index] <= K) {
            interArray.add(arr[index]);
            sum += arr[index];
            subsequenceOfSumK(arr, K, index + 1, interArray, answers, sum);
            interArray.remove(interArray.size() - 1);
            sum -= arr[index];
        }
        subsequenceOfSumK(arr, K, index+1, interArray, answers, sum);
    }
}
