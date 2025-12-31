import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int start = nums[0]; // beginning of current range

        for (int i = 0; i < nums.length; i++) {
            // If it's the last element OR the sequence breaks
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start == nums[i]) {
                    result.add(String.valueOf(start)); // single number
                } else {
                    result.add(start + "->" + nums[i]); // range
                }
                // Update start for next range
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return result;
    }
}