import java.util.*;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int x = 1; x <= n; x++) {
            // Find how many numbers are >= x
            int idx = Arrays.binarySearch(nums, x);
            
            if (idx < 0) {
                idx = -(idx + 1); // insertion point
            } else {
                // If found, move to the first occurrence >= x
                while (idx > 0 && nums[idx - 1] == x) {
                    idx--;
                }
            }
            
            int count = n - idx;
            if (count == x) {
                return x;
            }
        }
        
        return -1;
    }
}