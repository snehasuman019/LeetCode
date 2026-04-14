import java.util.*;
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        List<Integer> slots = new ArrayList<>();
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                slots.add(f[0]);
            }
        }
        int n = robot.size();
        int m = slots.size();
        long[][] dp = new long[n + 1][m + 1];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE / 2);
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j - 1];
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + Math.abs(robot.get(i - 1) - slots.get(j - 1)));
            }
        }
        return dp[n][m];
    }
}