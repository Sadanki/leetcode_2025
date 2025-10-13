class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // farthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                // We're stuck before reaching index i
                return false;
            }
            // Update the farthest we can go from here
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // If we never got stuck, we can reach the end
        return true;
    }
}