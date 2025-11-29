class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        
        // Step 1: find the largest square side possible
        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);
            maxLen = Math.max(maxLen, side);
        }
        
        // Step 2: count how many rectangles can form maxLen
        int count = 0;
        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);
            if (side == maxLen) {
                count++;
            }
        }
        
        return count;
    }
}