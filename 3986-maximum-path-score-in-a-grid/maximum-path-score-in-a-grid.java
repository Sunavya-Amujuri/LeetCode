class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][c] = max score at (i,j) with cost c
        int[][][] dp = new int[m][n][k + 1];

        // Initialize with -1 (invalid)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Starting cell
        int startCost = (grid[0][0] == 0) ? 0 : 1;
        int startScore = grid[0][0];

        if (startCost > k) return -1;
        dp[0][0][startCost] = startScore;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] == -1) continue;

                    // Move RIGHT
                    if (j + 1 < n) {
                        int newCost = cost + (grid[i][j+1] == 0 ? 0 : 1);
                        if (newCost <= k) {
                            dp[i][j+1][newCost] = Math.max(
                                dp[i][j+1][newCost],
                                dp[i][j][cost] + grid[i][j+1]
                            );
                        }
                    }

                    // Move DOWN
                    if (i + 1 < m) {
                        int newCost = cost + (grid[i+1][j] == 0 ? 0 : 1);
                        if (newCost <= k) {
                            dp[i+1][j][newCost] = Math.max(
                                dp[i+1][j][newCost],
                                dp[i][j][cost] + grid[i+1][j]
                            );
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m-1][n-1][c]);
        }

        return ans;
    }
}