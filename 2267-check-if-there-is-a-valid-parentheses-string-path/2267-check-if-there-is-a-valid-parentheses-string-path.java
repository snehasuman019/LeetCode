class Solution {
    private int rows, cols;
    private char[][] grid;
    private boolean[][][] visited;

    /**
     * Determines if there's a valid path from top-left to bottom-right
     * where parentheses are balanced.
     * 
     * @param grid 2D array containing '(' and ')' characters
     * @return true if a valid balanced path exists, false otherwise
     */
    public boolean hasValidPath(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if ((rows + cols - 1) % 2 == 1 || 
            grid[0][0] == ')' || 
            grid[rows - 1][cols - 1] == '(') {
            return false;
        }
      
        this.grid = grid;
        visited = new boolean[rows][cols][rows + cols];
        return dfs(0, 0, 0);
    }

    /**
     * Performs depth-first search to find a valid balanced path.
     * 
     * @param row Current row position
     * @param col Current column position
     * @param balance Current balance of parentheses (incremented for '(', decremented for ')')
     * @return true if a valid path exists from current position, false otherwise
     */
    private boolean dfs(int row, int col, int balance) {
        if (visited[row][col][balance]) {
            return false;
        }
        visited[row][col][balance] = true;
        balance += grid[row][col] == '(' ? 1 : -1;
        if (balance < 0 || balance > rows - row + cols - col) {
            return false;
        }
        if (row == rows - 1 && col == cols - 1) {
            return balance == 0;
        }
        final int[] dirs = {1, 0, 1};
        for (int d = 0; d < 2; d++) {
            int nextRow = row + dirs[d];
            int nextCol = col + dirs[d + 1];
            if (nextRow >= 0 && nextRow < rows && 
                nextCol >= 0 && nextCol < cols && 
                dfs(nextRow, nextCol, balance)) {
                return true;
            }
        }
        return false;
    }
}
