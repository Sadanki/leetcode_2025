class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0; // Points to where the next non-zero should go

        // First pass: Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // Second pass: Fill the rest with 0s
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
