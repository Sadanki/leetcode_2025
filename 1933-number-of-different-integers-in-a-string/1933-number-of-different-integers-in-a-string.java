import java.util.*;

class Solution {
    public int numDifferentIntegers(String word) {
        // Replace non-digits with space
        String replaced = word.replaceAll("[a-z]", " ");
        
        // Split by spaces
        String[] parts = replaced.trim().split("\\s+");
        
        Set<String> set = new HashSet<>();
        
        for (String part : parts) {
            if (!part.isEmpty()) {
                // Remove leading zeros
                String normalized = part.replaceFirst("^0+", "");
                if (normalized.isEmpty()) {
                    normalized = "0"; // handle case like "000"
                }
                set.add(normalized);
            }
        }
        
        return set.size();
    }
}