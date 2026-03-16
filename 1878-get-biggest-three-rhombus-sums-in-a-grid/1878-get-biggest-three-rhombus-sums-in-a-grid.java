import java.util.*;
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                add(set, grid[i][j]);
                for (int size = 1; ; size++) {
                    if (i + 2 * size >= m ||
                        j - size < 0 ||
                        j + size >= n)
                        break;
                    int sum = 0;
                    int x = i;
                    int y = j;
                    for (int k = 0; k < size; k++)
                        sum += grid[x + k][y - k];
                    for (int k = 0; k < size; k++)
                        sum += grid[x + size + k][y - size + k];
                    for (int k = 0; k < size; k++)
                        sum += grid[x + 2 * size - k][y + k];
                    for (int k = 0; k < size; k++)
                        sum += grid[x + size - k][y + size - k];
                    add(set, sum);
                }
            }
        }
        int[] ans = new int[set.size()];
        int idx = ans.length - 1;
        for (int val : set)
            ans[idx--] = val;
        return ans;
    }
    private void add(TreeSet<Integer> set, int val) {
        set.add(val);
        if (set.size() > 3)
            set.pollFirst();   
    }
}