public class Solution {
    public int[] ShortestToChar(string s, char c) {
        int n = s.Length;
        int[] result = new int[n];

        // Left-to-right
        int prev = -n; 
        for (int i = 0; i < n; i++) {
            if (s[i] == c) prev = i;
            result[i] = i - prev;
        }

        // Right-to-left
        prev = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == c) prev = i;
            result[i] = Math.Min(prev - i, result[i]);
        }

        return result;
    }
}