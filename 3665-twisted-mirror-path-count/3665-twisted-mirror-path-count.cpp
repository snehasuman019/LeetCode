
class Solution {
public:
    int uniquePaths(vector<vector<int>>& grid) {

        const int MOD = 1e9 + 7;

        int m = grid.size();
        int n = grid[0].size();

        vector<vector<long long>> right(
            m, vector<long long>(n, 0)
        );

        vector<vector<long long>> down(
            m, vector<long long>(n, 0)
        );

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                long long ways;

                // Starting position
                if (i == 0 && j == 0) {
                    ways = 1;
                } else {
                    ways = (right[i][j] + down[i][j]) % MOD;
                }

                // Mirror cell
                if (grid[i][j] == 1) {

                    // Entered while moving right
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % MOD;
                    }

                    // Entered while moving down
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % MOD;
                    }

                }

                // Empty cell
                else {

                    // Move right
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + ways) % MOD;
                    }

                    // Move down
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + ways) % MOD;
                    }
                }
            }
        }

        return (right[m - 1][n - 1] +
                down[m - 1][n - 1]) % MOD;
    }
};
