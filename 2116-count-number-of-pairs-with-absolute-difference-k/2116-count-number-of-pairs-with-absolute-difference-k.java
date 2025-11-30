class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        
        for (int num : nums) {
            // check for pairs with difference k
            count += freq.getOrDefault(num - k, 0);
            count += freq.getOrDefault(num + k, 0);
            
            // update frequency
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}