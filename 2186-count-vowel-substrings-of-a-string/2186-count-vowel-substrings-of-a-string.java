import java.util.*;

class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!isVowel(c)) break; // stop if non-vowel
                set.add(c);
                if (set.size() == 5) { // all vowels present
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}