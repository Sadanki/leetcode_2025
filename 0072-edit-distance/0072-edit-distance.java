class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] = min operations to convert word1[0..i-1] → word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // delete all characters
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insert all characters
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],      // delete
                        Math.min(dp[i][j - 1],  // insert
                                 dp[i - 1][j - 1]) // replace
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}