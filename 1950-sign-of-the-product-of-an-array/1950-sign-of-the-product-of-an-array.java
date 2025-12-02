class Solution {
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        
        for (int num : nums) {
            if (num == 0) {
                return 0; // product becomes zero
            }
            if (num < 0) {
                negativeCount++;
            }
        }
        
        // If negatives are even → positive, else negative
        return (negativeCount % 2 == 0) ? 1 : -1;
    }
}