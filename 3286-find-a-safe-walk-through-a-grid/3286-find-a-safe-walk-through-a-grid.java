import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // Directions: up, down, left, right
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // visited[i][j][h] = true if cell (i,j) visited with health h
        boolean[][][] visited = new boolean[m][n][health+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, health});
        visited[0][0][health] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1], h = curr[2];
            
            // If current cell is unsafe, reduce health
            if (grid.get(i).get(j) == 1) {
                h--;
            }
            
            // If health drops to 0, skip
            if (h <= 0) continue;
            
            // Check if reached destination
            if (i == m-1 && j == n-1) return true;
            
            // Explore neighbors
            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !visited[ni][nj][h]) {
                    visited[ni][nj][h] = true;
                    q.offer(new int[]{ni, nj, h});
                }
            }
        }
        
        return false;
    }
}
