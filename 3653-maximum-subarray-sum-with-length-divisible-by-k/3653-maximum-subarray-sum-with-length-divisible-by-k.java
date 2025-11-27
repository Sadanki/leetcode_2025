class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        // Track minimum prefix sum for each remainder
        long[] minPrefix = new long[k];
        java.util.Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0; // base case
        
        long maxSum = Long.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int mod = i % k;
            if (minPrefix[mod] != Long.MAX_VALUE) {
                maxSum = Math.max(maxSum, prefix[i] - minPrefix[mod]);
            }
            // update min prefix for this mod
            minPrefix[mod] = Math.min(minPrefix[mod], prefix[i]);
        }
        
        return maxSum;
    }
}