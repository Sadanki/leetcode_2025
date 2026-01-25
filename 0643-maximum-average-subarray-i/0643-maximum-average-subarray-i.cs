using System;

public class Solution {
    public double FindMaxAverage(int[] nums, int k) {
        // Step 1: Calculate sum of first k elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Step 2: Slide the window across the array
        for (int i = k; i < nums.Length; i++) {
            sum += nums[i] - nums[i - k]; // add new, remove old
            maxSum = Math.Max(maxSum, sum);
        }

        // Step 3: Return maximum average
        return (double)maxSum / k;
    }
}