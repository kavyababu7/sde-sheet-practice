package sde.sheet.practice.dp.strings;

import java.util.Arrays;

public class LCS {

        public static void main(String[] args) {
            System.out.println(longestCommonSubsequence("abc", "ab"));
        }
        public static int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length();
            int len2 = text2.length();
            int[][] dp = new int[len1][len2];
            for (int[] dpArr: dp) {
                Arrays.fill(dpArr, -1);
            }
            return lcs(text1, len1-1, text2, len2-1, dp);
        }

        private static int lcs(String text1, int idx1, String text2, int idx2, int[][] dp) {
            if (idx1 < 0 || idx2 < 0) {
                return 0;
            }
            if (dp[idx1][idx2] == -1) {
                return dp[idx1][idx2];
            }
            if (text1.charAt(idx1) == text2.charAt(idx2)) {
                dp[idx1][idx2] = 1 + lcs(text1, idx1-1, text2, idx2-1, dp);
                return dp[idx1][idx2];
            }
            dp[idx1][idx2] = Math.max(lcs(text1, idx1, text2, idx2-1, dp), lcs(text1, idx1-1, text2, idx2, dp));
            return dp[idx1][idx2];
        }

}
