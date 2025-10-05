class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for fast lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i] means: can s[0...i-1] be segmented?
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always segmentable

        // Loop over the string
        for (int i = 1; i <= s.length(); i++) {
            // Try every possible split point j
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] is segmentable AND s[j...i-1] is a word
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further splits
                }
            }
        }

        // Final answer: can the whole string be segmented?
        return dp[s.length()];
    }
}