package sde.sheet.practice.dp;

class EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i<= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i<= l2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] =  0 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i][j-1],//insert
                            Math.min(
                                    dp[i-1][j],//deletion
                                    dp[i-1][j-1]  //replace
                            )
                    );
                }
            }
        }
        return dp[l1][l2];
    }

    private int minDist(String w1, int i, String w2, int j) {

        if (w1.charAt(i) == w2.charAt(j)) {
            return 0 + minDist(w1, i-1, w2, j-1);
        } else {
            return Math.min(
                    1 + minDist(w1, i, w2, j-1),//insert
                    Math.min(
                            1 + minDist(w1, i-1, w2, j),//deletion
                            1 + minDist(w1, i-1, w2, j-1)  //replace
                    )
            );
        }
    }
}
