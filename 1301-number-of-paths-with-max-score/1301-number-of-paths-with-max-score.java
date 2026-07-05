class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        // dp[i][j][0] = max score to reach (i,j)
        // dp[i][j][1] = number of paths achieving that max score
        int[][][] dp = new int[n][n][2];

        // Initialize with -1 (unreachable)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = 0;
            }
        }

        // Starting point (bottom-right 'S')
        dp[n-1][n-1][0] = 0;
        dp[n-1][n-1][1] = 1;

        // Traverse from bottom-right to top-left
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                char c = board.get(i).charAt(j);
                if (c == 'X') continue; // obstacle

                // Skip start cell 'S'
                int val = (c == 'S' || c == 'E') ? 0 : c - '0';

                // Check three possible moves: down, right, diagonal
                int[][] dirs = {{1,0},{0,1},{1,1}};
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < n && nj < n && dp[ni][nj][0] != -1) {
                        int newScore = dp[ni][nj][0] + val;

                        if (newScore > dp[i][j][0]) {
                            // Found better score
                            dp[i][j][0] = newScore;
                            dp[i][j][1] = dp[ni][nj][1];
                        } else if (newScore == dp[i][j][0]) {
                            // Same max score, add paths
                            dp[i][j][1] = (int)((dp[i][j][1] + (long)dp[ni][nj][1]) % MOD);
                        }
                    }
                }
            }
        }

        // Answer is at top-left 'E'
        if (dp[0][0][0] == -1) return new int[]{0,0};
        return new int[]{dp[0][0][0], dp[0][0][1]};
    }
}
