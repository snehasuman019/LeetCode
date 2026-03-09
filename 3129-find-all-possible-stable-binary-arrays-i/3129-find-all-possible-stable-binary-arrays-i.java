class Solution {
    static final int MOD = 1_000_000_007;  
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int z = 1; z <= Math.min(limit, zero); z++) {
            dp[z][0][0] = 1;
        }
        for (int o = 1; o <= Math.min(limit, one); o++) {
            dp[0][o][1] = 1;
        }
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (dp[i][j][0] > 0) {
                    for (int add = 1; add <= limit && j + add <= one; add++) {
                        dp[i][j + add][1] = (dp[i][j + add][1] + dp[i][j][0]) % MOD;
                    }
                }
                if (dp[i][j][1] > 0) {
                    for (int add = 1; add <= limit && i + add <= zero; add++) {
                        dp[i + add][j][0] = (dp[i + add][j][0] + dp[i][j][1]) % MOD;
                    }
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
