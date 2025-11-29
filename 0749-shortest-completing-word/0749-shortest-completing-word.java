class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Step 1: build frequency map for licensePlate
        int[] need = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                need[c - 'a']++;
            }
        }
        
        String result = null;
        
        // Step 2: check each word
        for (String word : words) {
            if (covers(word, need)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        
        return result;
    }
    
    // Helper: check if word covers all needed letters
    private boolean covers(String word, int[] need) {
        int[] count = new int[26];
        for (char c : word.toLowerCase().toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] < need[i]) {
                return false;
            }
        }
        return true;
    }
}