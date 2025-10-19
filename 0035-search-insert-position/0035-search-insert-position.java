class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // insertion point
    }
}

/*Safer Formula: mid = left + (right - left) / 2

This avoids overflow because:
- right - left is guaranteed to be within bounds.
- You’re adding a smaller number to left.
\U0001f522 Example:
Let’s say:
left = 2_000_000_000
right = 2_147_483_647


- 

- (left + right) / 2 → overflow
- left + (right - left) / 2 → safe:
- right - left = 147_483_647
- mid = 2_000_000_000 + 73_741_823 = 2_073_741_823
No overflow
*/

