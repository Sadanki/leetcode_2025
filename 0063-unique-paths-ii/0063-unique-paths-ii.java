class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Get the number of rows and columns in the grid
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting cell has an obstacle, there's no way to start
        if (obstacleGrid[0][0] == 1) return 0;

        // Create a DP table to store number of paths to each cell
        int[][] dp = new int[m][n];

        // Initialize the starting cell with 1 path (we start here)
        dp[0][0] = 1;

        // Traverse the grid row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // If current cell is an obstacle, no path can go through it
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }

                // If not an obstacle and not in first row or column,
                // add paths from top and left
                else if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

                // If in first column (but not first row), only path is from top
                else if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                // If in first row (but not first column), only path is from left
                else if (j > 0) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // Return the number of paths to bottom-right corner
        return dp[m - 1][n - 1];
    }
}