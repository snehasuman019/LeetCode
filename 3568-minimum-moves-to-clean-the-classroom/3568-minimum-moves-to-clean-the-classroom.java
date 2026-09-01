import java.util.*;

class Solution {
    static class State {
        int x, y, energy, mask, moves;
        State(int x, int y, int energy, int mask, int moves) {
            this.x = x;
            this.y = y;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int startX = -1, startY = -1;
        List<int[]> litter = new ArrayList<>();
        
        // Collect positions of S and L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i; startY = j;
                } else if (c == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }
        
        int litterCount = litter.size();
        int targetMask = (1 << litterCount) - 1;
        
        // BFS queue
        Queue<State> q = new LinkedList<>();
        // visited[x][y][mask][energy] → avoid revisiting same state
        boolean[][][][] visited = new boolean[m][n][1 << litterCount][energy + 1];
        
        q.offer(new State(startX, startY, energy, 0, 0));
        visited[startX][startY][0][energy] = true;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            State cur = q.poll();
            
            // Check if all litter collected
            if (cur.mask == targetMask) return cur.moves;
            
            for (int[] d : dirs) {
                int nx = cur.x + d[0], ny = cur.y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                char cell = classroom[nx].charAt(ny);
                if (cell == 'X') continue; // obstacle
                
                int newEnergy = cur.energy - 1;
                if (newEnergy < 0) continue;
                
                int newMask = cur.mask;
                // Collect litter if present
                for (int k = 0; k < litterCount; k++) {
                    if (litter.get(k)[0] == nx && litter.get(k)[1] == ny) {
                        newMask |= (1 << k);
                    }
                }
                
                // Reset energy if on 'R'
                if (cell == 'R') newEnergy = energy;
                
                if (!visited[nx][ny][newMask][newEnergy]) {
                    visited[nx][ny][newMask][newEnergy] = true;
                    q.offer(new State(nx, ny, newEnergy, newMask, cur.moves + 1));
                }
            }
        }
        
        return -1; // impossible
    }
}
