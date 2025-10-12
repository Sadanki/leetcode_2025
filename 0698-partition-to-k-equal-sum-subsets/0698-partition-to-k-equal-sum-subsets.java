import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        
        // If total sum is not divisible by k, partitioning is impossible
        if (totalSum % k != 0) return false;
        
        int target = totalSum / k;
        boolean[] visited = new boolean[nums.length];
        
        // Sort in descending order for optimization
        Arrays.sort(nums);
        reverse(nums); // helper to reverse array
        
        return backtrack(nums, visited, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int startIndex, int currentSum, int target) {
        // If we've formed k - 1 valid subsets, the last one must be valid
        if (k == 1) return true;
        
        // If current subset reaches target, start forming next subset
        if (currentSum == target) {
            return backtrack(nums, visited, k - 1, 0, 0, target);
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i] || currentSum + nums[i] > target) continue;
            
            visited[i] = true;
            if (backtrack(nums, visited, k, i + 1, currentSum + nums[i], target)) return true;
            visited[i] = false; // backtrack
        }
        
        return false;
    }

    // Helper to reverse array in-place
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}