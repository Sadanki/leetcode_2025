public class Solution {
    public int LongestConsecutive(int[] nums) {
        if (nums.Length == 0) return 0;

        var set = new HashSet<int>(nums);
        int longest = 0;

        foreach (int num in set) { // iterate over set, not nums
            // only start if it's the beginning of a sequence
            if (!set.Contains(num - 1)) {
                int currentNum = num;
                int length = 1;

                while (set.Contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.Max(longest, length);
            }
        }

        return longest;
    }
}