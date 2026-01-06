import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums); // sort ascending
        int n = nums.length;
        
        // check from largest side backwards
        for (int i = n - 1; i >= 2; i--) {
            int a = nums[i - 2], b = nums[i - 1], c = nums[i];
            if (a + b > c) {
                return a + b + c; // valid triangle
            }
        }
        
        return 0; // no valid triangle
    }
}