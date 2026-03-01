public class Solution {
    public void WiggleSort(int[] nums) {
        int n = nums.Length;
        int[] sorted = (int[])nums.Clone();
        Array.Sort(sorted);

        int mid = (n + 1) / 2; // middle split
        int left = mid - 1;    // end of smaller half
        int right = n - 1;     // end of larger half

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];  // smaller half
            } else {
                nums[i] = sorted[right--]; // larger half
            }
        }
    }
}