package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequencesOfSumCount {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int K = 3;
        System.out.println(countOfSubsequencesOfSum(0, arr, K, 0, new ArrayList<Integer>()));
    }

    private static int countOfSubsequencesOfSum(int index, int[] arr, int k, int sum, List<Integer> interim) {
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        interim.add(arr[index]);
        sum += arr[index];
        int left = countOfSubsequencesOfSum(index + 1, arr, k, sum, interim);
        interim.remove(interim.size() - 1);
        sum -= arr[index];
        int right = countOfSubsequencesOfSum(index + 1, arr, k, sum, interim);
        return left + right;
    }
}
