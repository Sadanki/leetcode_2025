class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        // Count frequencies for word1
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        
        // Count frequencies for word2
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        
        // Compare differences
        for (int i = 0; i < 26; i++) {
            if (Math.abs(freq1[i] - freq2[i]) > 3) {
                return false;
            }
        }
        
        return true;
    }
}