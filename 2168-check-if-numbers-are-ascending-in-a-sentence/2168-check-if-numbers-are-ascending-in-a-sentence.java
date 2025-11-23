class Solution {
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int prev = -1; // previous number (start with -1 since numbers are positive)
        
        for (String token : tokens) {
            // Check if token is a number (all digits)
            if (Character.isDigit(token.charAt(0))) {
                int num = Integer.parseInt(token);
                
                // Check strictly increasing condition
                if (num <= prev) {
                    return false;
                }
                prev = num;
            }
        }
        
        return true;
    }
}