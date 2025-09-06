class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // Step 1: If total sum is odd, we can't partition
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // Step 2: dp[i] means "can we make sum i from some subset of nums"
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // we can always make 0 sum with empty subset

        // Step 3: Process each number
        for (int num : nums) {
            // Go backwards so we don't reuse a number twice
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target]; // Step 4: Did we form sum = target?
    }
}
