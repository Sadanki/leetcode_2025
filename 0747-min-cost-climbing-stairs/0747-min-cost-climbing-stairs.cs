public class Solution {
    public int MinCostClimbingStairs(int[] cost) {
        int n = cost.Length;
        if (n == 1) return cost[0];
        if (n == 2) return Math.Min(cost[0], cost[1]);

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.Min(dp[i - 1], dp[i - 2]);
        }

        return Math.Min(dp[n - 1], dp[n - 2]);
    }
}