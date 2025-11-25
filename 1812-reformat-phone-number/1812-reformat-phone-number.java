class Solution {
    public String reformatNumber(String number) {
        // Step 1: Remove spaces and dashes
        String digits = number.replaceAll("[\\s-]", "");
        
        StringBuilder result = new StringBuilder();
        int i = 0, n = digits.length();
        
        // Step 2: Process blocks
        while (n - i > 4) {
            result.append(digits, i, i + 3).append("-");
            i += 3;
        }
        
        // Step 3: Handle last 2–4 digits
        if (n - i == 4) {
            result.append(digits, i, i + 2).append("-");
            result.append(digits, i + 2, i + 4);
        } else if (n - i == 3) {
            result.append(digits, i, i + 3);
        } else if (n - i == 2) {
            result.append(digits, i, i + 2);
        }
        
        return result.toString();
    }
}