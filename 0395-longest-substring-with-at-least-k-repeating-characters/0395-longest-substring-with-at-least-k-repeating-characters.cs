public class Solution {
    public int LongestSubstring(string s, int k) {
        int n = s.Length;
        int maxLen = 0;

        // Try all possible distinct character counts
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int uniqueCount = 0;   // distinct chars in window
            int countAtLeastK = 0; // chars with freq >= k

            while (right < n) {
                int rIndex = s[right] - 'a';
                if (freq[rIndex] == 0) uniqueCount++;
                freq[rIndex]++;
                if (freq[rIndex] == k) countAtLeastK++;
                right++;

                // Shrink window if too many distinct chars
                while (uniqueCount > targetUnique) {
                    int lIndex = s[left] - 'a';
                    if (freq[lIndex] == k) countAtLeastK--;
                    freq[lIndex]--;
                    if (freq[lIndex] == 0) uniqueCount--;
                    left++;
                }

                // Check condition
                if (uniqueCount == targetUnique && uniqueCount == countAtLeastK) {
                    maxLen = Math.Max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }
}