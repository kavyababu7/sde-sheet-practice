package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> intermediateArr = new ArrayList<>();
        List<List<Integer>> answers = new ArrayList<>();
        subsequence(arr, intermediateArr, 0, answers);
        System.out.println(answers);
    }

    private static void subsequence(int[] arr, ArrayList<Integer> intermediateArr, int index, List<List<Integer>> answers) {
        if (index == arr.length) {
            ArrayList<Integer> integers = new ArrayList<>(intermediateArr);
            answers.add(integers);
            return;
        }
        intermediateArr.add(arr[index]);
        subsequence(arr, intermediateArr, index+1, answers);
        intermediateArr.remove(intermediateArr.size()-1);
        subsequence(arr, intermediateArr, index+1, answers);
    }
}
