class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        // Find count of negatives using binary search
        int negCount = firstIndex(nums, 0); // index of first element >= 0
        
        // Find count of positives using binary search
        int posCount = n - firstIndex(nums, 1); // index of first element >= 1
        
        return Math.max(negCount, posCount);
    }
    
    // Binary search: find first index where nums[i] >= target
    private int firstIndex(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}