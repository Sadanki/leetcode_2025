class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;        // Number of rows
        int n = grid[0].length;     // Number of columns
        
        // Create a DP table with the same dimensions as grid
        int[][] dp = new int[m][n];
        
        // Initialize the starting point
        dp[0][0] = grid[0][0];
        
        // Fill the first row (can only come from left)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Fill the first column (can only come from top)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}