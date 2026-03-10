class Solution {
    static final int MOD = 1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][] dp0 = new long[zero + 1][one + 1]; 
        long[][] dp1 = new long[zero + 1][one + 1]; 
        long[][] pref0 = new long[zero + 1][one + 1]; 
        long[][] pref1 = new long[zero + 1][one + 1]; 
        for (int i = 1; i <= zero && i <= limit; i++) {
            dp0[i][0] = 1;
        }
        for (int j = 1; j <= one && j <= limit; j++) {
            dp1[0][j] = 1;
        }
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                pref0[i][j] = ((j > 0 ? pref0[i][j - 1] : 0) + dp0[i][j]) % MOD;
                pref1[i][j] = ((i > 0 ? pref1[i - 1][j] : 0) + dp1[i][j]) % MOD;
            }
        }
            for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i > 0 && j > 0) {
                    int l = Math.max(0, i - limit);
                    long sum = pref1[i - 1][j] - (l > 0 ? pref1[l - 1][j] : 0);
                    dp0[i][j] = (sum % MOD + MOD) % MOD;
                    l = Math.max(0, j - limit);
                    sum = pref0[i][j - 1] - (l > 0 ? pref0[i][l - 1] : 0);
                    dp1[i][j] = (sum % MOD + MOD) % MOD;
                }
                pref0[i][j] = ((j > 0 ? pref0[i][j - 1] : 0) + dp0[i][j]) % MOD;
                pref1[i][j] = ((i > 0 ? pref1[i - 1][j] : 0) + dp1[i][j]) % MOD;
            }
        }
        return (int)((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}
