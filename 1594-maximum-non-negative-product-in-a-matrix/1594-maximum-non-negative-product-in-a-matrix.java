class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1000000007;
        int m = grid.length, n = grid[0].length;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];
        maxDP[0][0] = minDP[0][0] = grid[0][0];
        for(int j = 1; j<n; j++){
            maxDP[0][j] = maxDP[0][j-1] * grid[0][j];
            minDP[0][j] = maxDP[0][j];
        }
        for(int i=1; i<m; i++){
            maxDP[i][0] = maxDP[i-1][0] * grid[i][0];
            minDP[i][0] = maxDP[i][0];

        }
            for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                long maxFromTop = Math.max(maxDP[i-1][j] * val, minDP[i-1][j] * val);
                long maxFromLeft = Math.max(maxDP[i][j-1] * val, minDP[i][j-1] * val);
                long minFromTop = Math.min(maxDP[i-1][j] * val, minDP[i-1][j] * val);
                long minFromLeft = Math.min(maxDP[i][j-1] * val, minDP[i][j-1] * val);
                maxDP[i][j] = Math.max(maxFromTop, maxFromLeft);
                minDP[i][j] = Math.min(minFromTop, minFromLeft);
            }
        }
        long result = maxDP[m-1][n-1];
        return result < 0 ? -1 : (int)(result % MOD);
    }
}
