import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Count frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int longest = 0;
        
        // Check for harmonious subsequences
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                longest = Math.max(longest, freq.get(key) + freq.get(key + 1));
            }
        }
        
        return longest;
    }
}