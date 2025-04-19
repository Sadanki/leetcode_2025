class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0; // Pointer for the position to place non-zero elements

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // XOR Swap nums[left] and nums[right] without a temporary variable
                if (left != right) { // Prevent self XOR when left == right
                    nums[left] ^= nums[right];
                    nums[right] ^= nums[left];
                    nums[left] ^= nums[right];
                }
                left++; // Move the left pointer
            }
        }
    }
}
