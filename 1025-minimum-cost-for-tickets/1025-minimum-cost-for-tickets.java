class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer[] memo = new Integer[n];
        return dp(0, days, costs, memo);
    }

    private int dp(int i, int[] days, int[] costs, Integer[] memo) {
        if (i >= days.length) return 0;  // base case: no more days left
        if (memo[i] != null) return memo[i];

        // Option 1: Buy 1-day pass
        int cost1 = costs[0] + dp(nextIndex(i, days, days[i] + 1), days, costs, memo);

        // Option 2: Buy 7-day pass
        int cost7 = costs[1] + dp(nextIndex(i, days, days[i] + 7), days, costs, memo);

        // Option 3: Buy 30-day pass
        int cost30 = costs[2] + dp(nextIndex(i, days, days[i] + 30), days, costs, memo);

        // Take minimum of all
        memo[i] = Math.min(cost1, Math.min(cost7, cost30));
        return memo[i];
    }

    // Find next index not covered by the pass
    private int nextIndex(int i, int[] days, int validUntil) {
        while (i < days.length && days[i] < validUntil) {
            i++;
        }
        return i;
    }
}
