class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }
        return ans;
    }
    
    private int dfs(int i, int[] arr, int d, int[] dp) {
        if (dp[i] != -1) return dp[i];
        
        int n = arr.length;
        int maxLen = 1;
        for (int x = 1; x <= d && i + x < n; x++) {
            if (arr[i + x] >= arr[i]) break; 
            maxLen = Math.max(maxLen, 1 + dfs(i + x, arr, d, dp));
        }
        for (int x = 1; x <= d && i - x >= 0; x++) {
            if (arr[i - x] >= arr[i]) break; 
            maxLen = Math.max(maxLen, 1 + dfs(i - x, arr, d, dp));
        }
        
        return dp[i] = maxLen;
    }
}
