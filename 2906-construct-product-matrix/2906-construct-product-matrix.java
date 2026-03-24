class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;
        int[] arr = new int[size];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val % 12345;
            }
        }
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i-1] * arr[i-1]) % 12345;
        }
        
        suffix[size-1] = 1;
        for (int i = size-2; i >= 0; i--) {
            suffix[i] = (suffix[i+1] * arr[i+1]) % 12345;
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < size; i++) {
            int prod = (prefix[i] * suffix[i]) % 12345;
            result[i/m][i%m] = prod;
        }
        
        return result;
    }
}
