class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        
        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Find the first non-zero frequency
        int target = 0;
        for (int f : freq) {
            if (f > 0) {
                target = f;
                break;
            }
        }
        
        // Compare all non-zero frequencies
        for (int f : freq) {
            if (f > 0 && f != target) {
                return false;
            }
        }
        
        return true;
    }
}