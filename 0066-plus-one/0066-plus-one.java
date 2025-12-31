class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse from the last digit backwards
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++; // add 1
            if (digits[i] < 10) {
                return digits; // no carry, return immediately
            }
            digits[i] = 0; // carry over
        }
        
        // If all digits were 9, we need a bigger array
        int[] result = new int[digits.length + 1];
        result[0] = 1; // first digit is 1, rest are 0
        return result;
    }
}
