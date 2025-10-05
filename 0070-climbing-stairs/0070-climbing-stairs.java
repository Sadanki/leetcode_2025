class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); // Initialize memo table
        return countWays(n, dp);
    }

    private int countWays(int i, int[] dp) {
        if (i <= 1) return 1; // Base cases: 0 or 1 step

        if (dp[i] != -1) return dp[i]; // Already computed

        // Recursive relation: ways to reach step i
        dp[i] = countWays(i - 1, dp) + countWays(i - 2, dp);
        return dp[i];
    }
}