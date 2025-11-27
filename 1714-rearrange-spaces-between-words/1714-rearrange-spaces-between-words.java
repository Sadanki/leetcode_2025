class Solution {
    public String reorderSpaces(String text) {
        int totalSpaces = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') totalSpaces++;
        }
        
        // Split words by spaces
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        
        // If only one word, all spaces go to the end
        if (wordCount == 1) {
            return words[0] + " ".repeat(totalSpaces);
        }
        
        int spacesBetween = totalSpaces / (wordCount - 1);
        int extraSpaces = totalSpaces % (wordCount - 1);
        
        String spaceStr = " ".repeat(spacesBetween);
        String result = String.join(spaceStr, words) + " ".repeat(extraSpaces);
        
        return result;
    }
}