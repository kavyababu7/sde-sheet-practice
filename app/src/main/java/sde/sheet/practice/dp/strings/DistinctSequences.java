package sde.sheet.practice.dp.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class DistinctSequences {
    public static void main(String[] args) {
        String s = "babgbag"; String t = "bag";
        System.out.println(numDistinct(s, t));
        System.out.println(numDistinctOptimized(s, t));
        System.out.println(numDistinctOptimizedMore(s, t));
    }
    public static int numDistinct(String s, String t) {
        //return distinctSub(s, s.length()-1, t, t.length()-1);
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 1;
        }
        for (int idx1 = 1; idx1 <= len1; idx1++) {
            for (int idx2 = 1; idx2 <= len2; idx2++) {
                if (s.charAt(idx1-1) == t.charAt(idx2-1)) {
                    dp[idx1][idx2] = dp[idx1-1][idx2-1] + dp[idx1-1][idx2];
                } else {
                    dp[idx1][idx2] = dp[idx1-1][idx2];
                }
            }
        }
        return dp[len1][len2];

    }

    public static int numDistinctOptimized(String s, String t) {
        //return distinctSub(s, s.length()-1, t, t.length()-1);
        int len1 = s.length();
        int len2 = t.length();
        int[] curr = new int[len2+1];
        int[] prev = new int[len2+1];

        Arrays.fill(curr, 0);
        Arrays.fill(prev, 0);
        prev[0] = 1;
        curr[0] = 1;
        for (int idx1 = 1; idx1 <= len1; idx1++) {
            for (int idx2 = 1; idx2 <= len2; idx2++) {
                if (s.charAt(idx1-1) == t.charAt(idx2-1)) {
                    curr[idx2] = prev[idx2-1] + prev[idx2];
                } else {
                    curr[idx2] = prev[idx2];
                }
            }
            prev = Arrays.copyOf(curr, len2+1);
        }
        return prev[len2];

    }


    public static int numDistinctOptimizedMore(String s, String t) {
        //return distinctSub(s, s.length()-1, t, t.length()-1);
        int len1 = s.length();
        int len2 = t.length();
        int[] curr = new int[len2+1];
        int[] prev = new int[len2+1];

        Arrays.fill(curr, 0);
        Arrays.fill(prev, 0);
        prev[0] = 1;
        curr[0] = 1;
        for (int idx1 = 1; idx1 <= len1; idx1++) {
            for (int idx2 = len2; idx2 >= 1; idx2--) {
                if (s.charAt(idx1-1) == t.charAt(idx2-1)) {
                    prev[idx2] = prev[idx2-1] + prev[idx2];
                }
            }
        }
        return prev[len2];

    }
}
