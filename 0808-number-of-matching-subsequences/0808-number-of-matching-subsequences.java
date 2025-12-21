import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // Step 1: Preprocess s
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int count = 0;
        // Step 2: Check each word
        for (String word : words) {
            if (isSubsequence(word, map)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubsequence(String word, Map<Character, List<Integer>> map) {
        int prevIndex = -1;
        for (char c : word.toCharArray()) {
            if (!map.containsKey(c)) return false;
            List<Integer> indices = map.get(c);

            // Binary search for next index > prevIndex
            int pos = Collections.binarySearch(indices, prevIndex + 1);
            if (pos < 0) pos = -pos - 1; // insertion point
            if (pos == indices.size()) return false;

            prevIndex = indices.get(pos);
        }
        return true;
    }
}