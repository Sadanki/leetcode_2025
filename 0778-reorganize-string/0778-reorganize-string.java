import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build a max heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());

        // Step 3: Rebuild the string
        StringBuilder result = new StringBuilder();
        Character prevChar = null;
        int prevCount = 0;

        while (!maxHeap.isEmpty()) {
            char currChar = maxHeap.poll();
            result.append(currChar);
            freqMap.put(currChar, freqMap.get(currChar) - 1);

            // If previous character still has remaining count, push it back
            if (prevChar != null && prevCount > 0) {
                maxHeap.offer(prevChar);
            }

            // Update previous character and its count
            prevChar = currChar;
            prevCount = freqMap.get(currChar);
        }

        // Step 4: Check if result is valid
        return result.length() == s.length() ? result.toString() : "";
    }
}