class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int count = 0; // count violations
        
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                count++;
                if (count > 1) return false;
                
                // Check if removing nums[i] or nums[i-1] works
                if (i > 1 && nums[i] <= nums[i - 2] && i < n - 1 && nums[i + 1] <= nums[i - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}