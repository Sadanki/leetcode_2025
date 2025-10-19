import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(tails, num);
            if (idx < 0) idx = -(idx + 1); // insertion point

            if (idx == tails.size()) {
                tails.add(num); // extend the sequence
            } else {
                tails.set(idx, num); // replace to maintain minimal tail
            }
        }

        return tails.size();
    }
}