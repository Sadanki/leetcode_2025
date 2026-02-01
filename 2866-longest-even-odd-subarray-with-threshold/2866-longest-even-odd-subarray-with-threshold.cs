public class Solution {
    public int LongestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.Length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            // Subarray must start with even number <= threshold
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int len = 1;
                int prev = nums[i];

                for (int j = i + 1; j < n; j++) {
                    // Check threshold
                    if (nums[j] > threshold) break;

                    // Check alternating parity
                    if ((prev % 2 == 0 && nums[j] % 2 == 1) ||
                        (prev % 2 == 1 && nums[j] % 2 == 0)) {
                        len++;
                        prev = nums[j];
                    } else {
                        break;
                    }
                }

                maxLen = Math.Max(maxLen, len);
            }
        }

        return maxLen;
    }
}