class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Initialize pointers for binary search
        int left = 0, right = nums.length - 1;

        // Binary search loop
        while (left < right) {
            // Calculate the middle index to check
            int mid = left + (right - left) / 2;

            // Ensure 'mid' is even for proper pair comparison
            if (mid % 2 == 1) mid--;  // If 'mid' is odd, move it one step back to make it even

            // Check if the current 'mid' element is part of a valid pair
            if (nums[mid] == nums[mid + 1]) {
                // If the pair is valid, the single element must be after this pair
                left = mid + 2;
            } else {
                // If the pair is not valid, the single element must be before or at 'mid'
                right = mid;
            }
        }

        // When left == right, we've found the single element
        return nums[left];
    }
}