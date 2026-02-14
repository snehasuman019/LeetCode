class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
       
        // dp[row][glass] represents the amount of champagne in that glass
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[0][0] = poured;
        
        for (int row = 0; row <= query_row; row++) {
            for (int glass = 0; glass <= row; glass++) {
                if (dp[row][glass] > 1) {
                    double excess = (dp[row][glass] - 1) / 2.0;
                    dp[row + 1][glass] += excess;
                    dp[row + 1][glass + 1] += excess;
                    dp[row][glass] = 1; // cap current glass at 1
                }
            }
        }
        
        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
