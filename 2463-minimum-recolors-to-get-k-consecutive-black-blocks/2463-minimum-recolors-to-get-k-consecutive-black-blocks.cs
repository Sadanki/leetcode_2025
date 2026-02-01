public class Solution {
    public int MinimumRecolors(string blocks, int k) {
        int n = blocks.Length;
        int whiteCount = 0;

        // Initial window of size k
        for (int i = 0; i < k; i++) {
            if (blocks[i] == 'W') whiteCount++;
        }

        int minRecolors = whiteCount;

        // Slide the window
        for (int i = k; i < n; i++) {
            if (blocks[i] == 'W') whiteCount++;
            if (blocks[i - k] == 'W') whiteCount--;

            minRecolors = Math.Min(minRecolors, whiteCount);
        }

        return minRecolors;
    }
}