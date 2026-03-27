class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            int shift = k % n;
            for (int j = 0; j < n; j++) {
                int newIndex;
                if (i % 2 == 0) { // even row → left shift
                    newIndex = (j + shift) % n;
                } else { // odd row → right shift
                    newIndex = (j - shift + n) % n;
                }
                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }
        return true;
    }
}
