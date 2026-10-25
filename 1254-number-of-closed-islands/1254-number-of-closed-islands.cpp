class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        int closedIslandCount = 0;
      
        // Direction vectors for exploring 4 adjacent cells (up, right, down, left)
        int directions[5] = {-1, 0, 1, 0, -1};
      
        // DFS function to check if current island is closed (not touching borders)
        // Returns 1 if the island is closed, 0 otherwise
        function<int(int, int)> dfs = [&](int row, int col) -> int {
            // Check if current cell is not on the border
            // If on border, the island is not closed
            int isClosed = (row > 0 && row < rows - 1 && col > 0 && col < cols - 1) ? 1 : 0;
          
            // Mark current cell as visited by changing 0 to 1
            grid[row][col] = 1;
          
            // Explore all 4 adjacent cells
            for (int k = 0; k < 4; ++k) {
                int nextRow = row + directions[k];
                int nextCol = col + directions[k + 1];
              
                // If adjacent cell is valid and is land (0), continue DFS
                if (nextRow >= 0 && nextRow < rows && 
                    nextCol >= 0 && nextCol < cols && 
                    grid[nextRow][nextCol] == 0) {
                    // Use bitwise AND to ensure all connected cells are closed
                    isClosed &= dfs(nextRow, nextCol);
                }
            }
          
            return isClosed;
        };
      
        // Iterate through all cells in the grid
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                // If cell is land (0) and forms a closed island, increment count
                if (grid[i][j] == 0 && dfs(i, j)) {
                    closedIslandCount++;
                }
            }
        }
      
        return closedIslandCount;
    }
};
