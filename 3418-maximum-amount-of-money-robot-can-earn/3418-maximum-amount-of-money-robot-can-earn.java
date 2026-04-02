class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < 3; p++) {
                    dp[i][j][p] = Integer.MIN_VALUE / 2; 
                }
            }
        }
        int val = coins[0][0];
        if (val >= 0) {
            for (int p = 0; p < 3; p++) dp[0][0][p] = val;
        } else {
            dp[0][0][0] = val; // no neutralization
            dp[0][0][1] = 0;   // neutralize once
        }
        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < 3; p++) {
                    if (i == 0 && j == 0) continue;
                    int bestPrev = Integer.MIN_VALUE / 2;
                    if (i > 0) bestPrev = Math.max(bestPrev, dp[i-1][j][p]);
                    if (j > 0) bestPrev = Math.max(bestPrev, dp[i][j-1][p]);
                    if (coins[i][j] >= 0) {
                        dp[i][j][p] = bestPrev + coins[i][j];
                    } else {
                        // option 1: don’t neutralize
                        dp[i][j][p] = bestPrev + coins[i][j];
                        // option 2: neutralize
                        if (p > 0) {
                            int neutralPrev = Integer.MIN_VALUE / 2;
                            if (i > 0) neutralPrev = Math.max(neutralPrev, dp[i-1][j][p-1]);
                            if (j > 0) neutralPrev = Math.max(neutralPrev, dp[i][j-1][p-1]);
                            dp[i][j][p] = Math.max(dp[i][j][p], neutralPrev);
                        }
                    }
                }
            }
        }
        // Answer is max over all neutralization states at bottom-right
        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}
