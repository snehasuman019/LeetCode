class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int[][] streetDirs = {
        {},                
        {2,3},              
        {0,1},             
        {2,1},              
        {3,1},              
        {2,0},             
        {3,0}               
    };
    int[] opposite = {1,0,3,2}; 
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);
    }
    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i == m-1 && j == n-1) return true;
        visited[i][j] = true;
        for (int d : streetDirs[grid[i][j]]) {
            int ni = i + dirs[d][0];
            int nj = j + dirs[d][1];
            if (ni < 0 || nj < 0 || ni >= m || nj >= n || visited[ni][nj]) continue;
            for (int nd : streetDirs[grid[ni][nj]]) {
                if (nd == opposite[d]) {
                    if (dfs(grid, ni, nj, visited)) return true;
                }
            }
        }
        return false;
    }
}
