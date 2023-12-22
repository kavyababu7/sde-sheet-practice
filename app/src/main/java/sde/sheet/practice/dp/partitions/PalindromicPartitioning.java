package sde.sheet.practice.dp.partitions;

import java.util.Arrays;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(palindromicPartition(s));
        System.out.println(palindromicPartitionMemoise(s));
        System.out.println(palindromicPartitionTabulation(s));
    }

    private static int palindromicPartition(String s) {
        return palindromicPartition(0, s)-1;
    }

    private static int palindromicPartition(int idx, String s) {
        if (idx == s.length()) {
            return 0;
        }
        String temp = "";
        int ways = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = idx; i < s.length(); i++) {
            temp += s.charAt(i);
            if (isPalindrome(temp)) {
                ways = 1 + palindromicPartition(i+1, s);
                mini = Math.min(ways, mini);
            }
        }
        return mini;
    }


    private static int palindromicPartitionMemoise(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return palindromicPartitionMemoise(0, s, dp)-1;
    }

    private static int palindromicPartitionMemoise(int idx, String s,int[] dp) {
        if (idx == s.length()) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        String temp = "";
        int ways;
        int mini = Integer.MAX_VALUE;
        for (int i = idx; i < s.length(); i++) {
            temp += s.charAt(i);
            if (isPalindrome(temp)) {
                ways = 1 + palindromicPartitionMemoise(i+1, s, dp);
                mini = Math.min(ways, mini);
            }
        }
        dp[idx] = mini;
        return mini;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    private static int palindromicPartitionTabulation(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 0;

        for (int idx = len-1; idx >= 0; idx--) {
            int mini = Integer.MAX_VALUE;
            String temp = "";
            for (int i = idx; i < s.length(); i++) {
                temp += s.charAt(i);
                if (isPalindrome(temp)) {
                    int ways = 1 + dp[i + 1];
                    mini = Math.min(ways, mini);
                }
            }
            dp[idx] = mini;
        }
        return dp[0]-1;
    }
}
