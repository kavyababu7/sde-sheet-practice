package sde.sheet.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //failed for getAllSubSequences
//		int[] arr = {30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4,3,2,1};
//		int[] arr = {5,5,5,5};
//		int[] arr = {1,2,3,4,5,6};
//        int[] arr = {5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        // failed for getIncreasingSubSequences
        int[] arr = {1322, 2061, 2373, 734, 329, 4339, 2523, 1151, 3000, 3805, 1970, 4523, 2248, 555, 4215, 4200, 1320, 4568, 522, 536, 2410, 3901, 4748, 1355, 2668, 3359, 2756, 4768, 4361, 2804, 1942, 4734, 570, 4162, 3282, 2637, 3152, 3198, 3424, 497, 866, 1126, 2780, 3328, 2504, 2154, 2297, 4611, 2591, 1158, 1530, 4782, 689, 755, 3949, 3143, 4674, 4191, 1940, 3643, 3370, 4630, 3775, 4499, 4788, 2620, 2980, 732, 2865, 1735, 1863, 2331, 2954, 2663, 691, 3854, 4560, 3292, 1921, 4021, 3753, 1658, 157, 1014, 2439, 1, 2979, 961, 2235, 1528, 639, 3367, 1956, 1903, 3656, 3045, 4875, 4954, 1733, 3437, 4729, 1528, 26, 1092, 3177, 1969, 4760, 464, 765, 1202, 4359, 2117, 3769, 1009, 4754, 905, 199, 1652, 3294, 3654, 93, 4662, 4749, 3438, 2766, 268, 199, 4570, 2024, 1613, 238, 4013, 4482, 3677, 2785, 1063, 1041, 2549, 2998, 2773, 2248, 484, 3228, 2780, 4762, 4031, 4660, 923, 3359, 1326, 4364, 254, 981, 570, 1707, 1845, 3135, 4603, 1718, 1092, 2517, 1427, 4805, 2035, 157, 2535, 2417, 3618, 501, 4884, 1615, 3678, 4806, 3402, 3263, 2899, 4930, 3994, 3512, 1931, 3111, 2107, 1512, 354, 2602, 4052, 2865, 1216, 4102, 2444, 3127, 4387, 3759, 3315, 3786, 1113, 152, 695, 4563, 728, 61, 4695, 505, 3643, 1032, 1431, 346, 2435, 2709, 2451, 3798, 27, 3644, 2655, 4999, 740, 850, 4127, 2102, 1231, 663, 3658, 4090, 4179, 1572, 4237, 256, 2862, 2557, 225, 439, 4708, 4127, 2457, 5000, 1228, 3704, 3060, 2773, 733, 2191, 319, 2663, 3645, 4588, 1567, 363, 3257, 4293, 1670, 696, 2278, 3284, 1364, 3420, 2575, 3733, 3397, 946, 2117, 718, 152, 300, 4220, 611, 4170, 3854, 4875, 416, 2832, 3786, 4087, 4786, 205, 3968, 1892, 4713, 2986, 4, 3945, 4899, 3308, 3441, 357, 657, 4106, 4730, 4759, 4766, 2700, 1420, 3408, 65, 199, 3150, 1523, 4781, 3372, 3493, 934, 4461, 1648, 343, 4552, 2141, 4986, 1589, 4150, 1875, 3462, 1022, 3410, 13, 1559, 1014, 3244, 3713, 4279, 3329, 924, 1979, 3452, 2508, 3677, 1178, 771, 2707, 976, 4366, 4408, 3502, 2954, 1968, 3314, 3142, 10, 301};
        int n = arr.length;
        List<List<Integer>> subsequences = new ArrayList();
//		getAllSubSequences(0, arr, n, new ArrayList(), subsequences);
//		int maxSize = 1;
//		for (int i = 0; i < n; i++) {
//			List<Integer> nums = subsequences.get(i);
//			// System.out.println(nums.size());
//			boolean increasing = true;
//			for (int j = 0; j<nums.size()-1; j++) {
//				if (nums.get(j) >= nums.get(j+1)) {
//					increasing = false;
//					break;
//				}
//			}
//			if (increasing) {
//					maxSize = Math.max(nums.size(), maxSize);
//				}
//		}
//		int[] maxValue = {1};
//		getIncreasingSubSequences(0, Integer.MIN_VALUE, arr, arr.length, new ArrayList(), maxValue);
//		System.out.println(maxValue[0]);
        int[][] dp = new int[arr.length][arr.length + 1];
        for (int[] dpArr : dp) {

            Arrays.fill(dpArr, -1);
        }
        int max = getLISBinarySearch(arr);
        System.out.println(max);
    }

    private static void getAllSubSequences(int index, int[] arr, int n, List<Integer> interim, List<List<Integer>> subsequences) {
        if (n == index) {
            subsequences.add(new ArrayList(interim));
            return;
        }
        interim.add(arr[index]);
        getAllSubSequences(index + 1, arr, n, interim, subsequences);
        interim.remove(interim.size() - 1);
        getAllSubSequences(index + 1, arr, n, interim, subsequences);
    }

    private static void getIncreasingSubSequences(int index, int prev, int[] arr, int n, List<Integer> interim, int[] maxLength) {
        if (n == index) {
            maxLength[0] = Math.max(interim.size(), maxLength[0]);
            return;
        }
        if (arr[index] > prev) {
            interim.add(arr[index]);
            getIncreasingSubSequences(index + 1, interim.get(interim.size() - 1), arr, n, interim, maxLength);
            interim.remove(interim.size() - 1);
        }
        getIncreasingSubSequences(index + 1, prev, arr, n, interim, maxLength);
    }

    //    private static int getLIS(int index, int prev, int[] arr, int[][] dp) {
//        if (index == arr.length) {
//            return 0;
//        }
//        if (dp[index][prev + 1] != -1) {
//            return dp[index][prev + 1];
//        }
//        int take = Integer.MIN_VALUE;
//        if (prev == -1 || arr[index] > arr[prev]) {
//            take = 1 + getLIS(index + 1, index, arr, dp);
//        }
//        int notTake = 0 + getLIS(index + 1, prev, arr, dp);
//        dp[index][prev + 1] = Math.max(take, notTake);
//        return dp[index][prev + 1];
//    }
    private static int getLISDp(int[] arr) {
        int n = arr.length;
//    int[][] dp = new int[n+1][n+1];
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int take = Integer.MIN_VALUE;
                if (prev == -1 || arr[index] > arr[prev]) {
                    take = 1 + next[index + 1];
                }
                int notTake = 0 + next[prev + 1];
                curr[prev + 1] = Math.max(take, notTake);
            }
            next = curr;

        }
        return next[0];
    }
    private static int getLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (arr[index] > arr[prev]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[index]);
        }
        return max;
    }

    private static int getLISBinarySearch(int[] arr){
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size()-1)) {
                temp.add(arr[i]);
            } else {
                int idx = lowerBound(temp, arr[i]);//Collections.binarySearch(temp, arr[i]);
//                if (idx < 0) {
//                    idx = -(idx+1);
//                }
                temp.set(idx, arr[i]);
            }
        }
        return temp.size();
    }

    private static int lowerBound(List<Integer> list, int num) {
        int high = list.size()-1;
        int low = 0;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (list.get(mid)>num){
                high = mid;
            } else if (list.get(mid)<num){
                low = mid+1;
            } else {
                return mid;
            }
        }
        return low;
    }
}