class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Build the final strings after applying backspaces
        StringBuilder finalS = buildFinalString(s);
        StringBuilder finalT = buildFinalString(t);

        // Compare the final results
        return finalS.toString().equals(finalT.toString());
    }

    // Helper function to build the final string after backspace operations
    private StringBuilder buildFinalString(String str) {
        StringBuilder result = new StringBuilder();

        // Loop through each character of the string
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                // If backspace, remove the last character if there's one
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                // Otherwise, add the character to the result
                result.append(ch);
            }
        }

        return result;
    }
}
