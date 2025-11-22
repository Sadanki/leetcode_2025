class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: sort array
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2]; // initial guess

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update closest if this sum is nearer to target
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++; // need bigger sum
                } else if (sum > target) {
                    right--; // need smaller sum
                } else {
                    return sum; // exact match
                }
            }
        }
        return closest;
    }
}