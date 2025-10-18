class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

       // Step 1: Find initial left boundary nums[left] <= nums[left + 1]: This checks if the current element is less than or equal to the next element. If the condition is true, the array is still in non-decreasing order (sorted from left to right).
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) return 0;

        // Step 2: Find initial right boundary
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // Step 3: Find min and max in the unsorted window
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Step 4: Expand left boundary
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Step 5: Expand right boundary
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}