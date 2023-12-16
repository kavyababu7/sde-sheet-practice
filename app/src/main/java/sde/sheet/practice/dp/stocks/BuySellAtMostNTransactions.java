package sde.sheet.practice.dp.stocks;

public class BuySellAtMostNTransactions {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len+1][2][3];
        for (int buy = 0; buy <= 1; buy++) {
            for(int cap = 1; cap <= 2; cap++) {
                dp[len][buy][cap] = 0;
            }
        }
        for (int idx = 0; idx <= len; idx++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[len][buy][0] = 0;
            }
        }
        for (int idx = len-1; idx <= 0; idx++) {
            for (int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max(
                                -prices[idx] + dp[idx+1][0][cap],
                                0 + dp[idx+1][1][cap]
                        );
                    } else {
                        dp[idx][buy][cap] = Math.max(
                                prices[idx] + dp[idx+1][1][cap-1],
                                0 + dp[idx+1][0][cap]
                        );
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
