package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfSumPresent {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int K = 6;
        boolean isPresent = subsequenceSum(arr, 0, K, 0, new ArrayList<Integer>());
        System.out.println(isPresent);
    }

    private static boolean subsequenceSum(int[] arr, int index, int K, int sum, List<Integer> interim) {
        if (arr.length == index) {
            return sum == K;
        }
        interim.add(arr[index] + 1);
        sum += arr[index];
        if (subsequenceSum(arr, index + 1, K, sum, interim)) {
            return true;
        }
        sum -= arr[index];
        interim.remove(interim.size() - 1);
        if (subsequenceSum(arr, index + 1, K, sum, interim)) {
            return true;
        }
        return false;
    }
}
