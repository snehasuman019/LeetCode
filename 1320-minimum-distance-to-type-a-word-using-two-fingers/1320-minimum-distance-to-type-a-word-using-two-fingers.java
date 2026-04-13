class Solution {
    private int[][] coords = new int[26][2];
    
    public Solution() {
        for (int i = 0; i < 26; i++) {
            coords[i][0] = i / 6; // row
            coords[i][1] = i % 6; 
        }
    }
    private int dist(int a, int b) {
        if (a == -1 || b == -1) return 0; 
        return Math.abs(coords[a][0] - coords[b][0]) + Math.abs(coords[a][1] - coords[b][1]);
    }
    
    public int minimumDistance(String word) {
        int n = word.length();
        int[] letters = new int[n];
        for (int i = 0; i < n; i++) {
            letters[i] = word.charAt(i) - 'A';
        }
        Integer[][][] dp = new Integer[n][27][27]; 
        return dfs(0, 26, 26, letters, dp);
    }
    
    private int dfs(int idx, int f1, int f2, int[] letters, Integer[][][] dp) {
        if (idx == letters.length) return 0;
        if (dp[idx][f1][f2] != null) return dp[idx][f1][f2];
        
        int cur = letters[idx];
        int cost1 = dist(f1 == 26 ? -1 : f1, cur) + dfs(idx + 1, cur, f2, letters, dp);
        int cost2 = dist(f2 == 26 ? -1 : f2, cur) + dfs(idx + 1, f1, cur, letters, dp);
        
        return dp[idx][f1][f2] = Math.min(cost1, cost2);
    }
}
