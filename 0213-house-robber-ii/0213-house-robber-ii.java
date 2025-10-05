import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Base cases
        if (n == 1) return nums[0]; // Only one house
        if (n == 2) return Math.max(nums[0], nums[1]); // Two houses

        // Since houses are in a circle, we can't rob both first and last
        // So we take the max of two scenarios:
        // 1. Rob houses from index 0 to n-2 (exclude last)
        // 2. Rob houses from index 1 to n-1 (exclude first)
        return Math.max(
            robLinear(nums, 0, n - 2),
            robLinear(nums, 1, n - 1)
        );
    }

    // Helper function for linear rob (House Robber I logic)
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]: max money two houses back
        int prev1 = 0; // dp[i-1]: max money one house back

        for (int i = start; i <= end; i++) {
            int pick = nums[i] + prev2; // Rob current house
            int skip = prev1;           // Skip current house
            int curr = Math.max(pick, skip); // Best of both options

            // Move window forward
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1; // Final max money
    }
}