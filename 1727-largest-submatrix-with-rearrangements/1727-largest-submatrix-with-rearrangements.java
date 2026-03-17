class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] heights = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            heights[0][j] = matrix[0][j];
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] == 1) {
                    heights[i][j] = heights[i-1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            int[] rowHeights = heights[i].clone();
            Arrays.sort(rowHeights); // ascending
            for (int j = 0; j < cols; j++) {
                int h = rowHeights[cols - 1 - j]; // descending
                maxArea = Math.max(maxArea, h * (j + 1));
            }
        }
        return maxArea;
    }
}
