class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int px, int py, char target) {
        int m = grid.length, n = grid[0].length;
        visited[x][y] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (grid[nx][ny] != target) continue;
            if (visited[nx][ny]) {
                if (!(nx == px && ny == py)) {
                    return true;
                }
            } else {
                if (dfs(grid, visited, nx, ny, x, y, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}