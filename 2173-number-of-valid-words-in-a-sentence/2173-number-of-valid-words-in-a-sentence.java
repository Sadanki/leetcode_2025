class Solution {
    public int countValidWords(String sentence) {
        String[] tokens = sentence.trim().split("\\s+");
        int count = 0;
        
        for (String token : tokens) {
            if (isValid(token)) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isValid(String token) {
        if (token.isEmpty()) return false;
        
        int hyphenCount = 0;
        int punctuationCount = 0;
        
        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            
            // Rule 1: No digits
            if (Character.isDigit(c)) return false;
            
            // Rule 2: Hyphen
            if (c == '-') {
                hyphenCount++;
                if (hyphenCount > 1) return false;
                // Must be surrounded by lowercase letters
                if (i == 0 || i == token.length() - 1) return false;
                if (!Character.isLowerCase(token.charAt(i - 1)) || 
                    !Character.isLowerCase(token.charAt(i + 1))) {
                    return false;
                }
            }
            
            // Rule 3: Punctuation
            if (c == '!' || c == '.' || c == ',') {
                punctuationCount++;
                if (punctuationCount > 1) return false;
                // Must be at the end
                if (i != token.length() - 1) return false;
            }
        }
        
        return true;
    }
}