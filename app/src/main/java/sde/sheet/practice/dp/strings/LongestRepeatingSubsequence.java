package sde.sheet.practice.dp.strings;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        int sub = lcr("aabcbdc");
        System.out.println(sub);
    }

    private static int lcr(String str) {
        int len  = str.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int idx1 = 1; idx1 <= len; idx1++) {
            for (int idx2 = 1; idx2 <= len; idx2++) {
                if (str.charAt(idx1-1) == str.charAt(idx2-1) && idx1 != idx2) {
                    dp[idx1][idx2] = 1+ dp[idx1-1][idx2-1];
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
                }
            }
        }
        int lcrLen = dp[len][len];
        String lcrString = "";
        for (int i = 0; i < lcrLen; i++) {
            lcrString += "*";
        }
        int i = len;
        int j = len;
        int idx = lcrLen-1;
        StringBuilder lrsSb = new StringBuilder(lcrString);
        while (i > 0 && j > 0) {
            if (str.charAt(i-1) == str.charAt(j-1) && i != j) {
                lrsSb.setCharAt(idx, str.charAt(i-1));
                idx--;
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(lrsSb);
        return lcrLen;
    }
}
