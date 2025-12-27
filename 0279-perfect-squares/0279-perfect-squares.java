class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        // Initialize with a large value
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;
        
        // Precompute all perfect squares <= n
        int maxSquareRoot = (int)Math.sqrt(n);
        int[] squares = new int[maxSquareRoot];
        for (int i = 1; i <= maxSquareRoot; i++) {
            squares[i - 1] = i * i;
        }
        
        // Fill dp array
        for (int i = 1; i <= n; i++) {
            for (int square : squares) {
                if (square > i) break;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        
        return dp[n];
    }
}