package sde.sheet.practice.dp.strings;

public class LongestPalindromic {
    public static void main(String[] args) {
        longestPalindrome("ababc");
    }
    public  static String longestPalindrome(String s) {
        int len = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[len+1][len+1];
        for(int i = 0; i <= len; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int idx1 = 1; idx1 <= len; idx1++) {
            for (int idx2 = 1; idx2 <= len; idx2++) {
                if (s.charAt(idx1-1) == r.charAt(idx2-1)) {
                    dp[idx1][idx2] = 1 +  dp[idx1-1][idx2-1];
                } else {
                    dp[idx1][idx2] = 0;
                }
            }
        }
        int pLen = dp[len][len];
        System.out.println(pLen);
        return buildString(s, r, pLen, dp, len);
    }

    private static String buildString(String s, String r, int plen, int[][] dp, int len) {

        String p = "";
        for (int i = 0; i < plen; i++) {
            p += "$";
        }
        int idx = plen-1;
        int i = len;
        int j = len;
        System.out.println(p);
        StringBuilder pBuilder = new StringBuilder(p);
        // while (i > 0 && j > 0) {
        //     if (s.charAt(i-1) == r.charAt(j-1)) {
        //         pBuilder.setCharAt(idx, s.charAt(i-1));
        //         idx--;
        //         i--;
        //         j--; 
        //     } else if (s.charAt(i-1) > r.charAt(j-1)) {
        //         i--;
        //     } else {
        //         j--;
        //     }
        // }
        return p;
    }
}