class Solution {
    public int findNthDigit(int n) {
        long nn = n;          // use long to avoid overflow during subtraction
        int d = 1;
        long count = 9;
        
        // Step 1: find the digit-length block
        while (nn > (long) d * count) {
            nn -= (long) d * count;
            d++;
            count *= 10; // next block has 9*10^(d-1) numbers
        }
        
        // Step 2: locate the exact number within the d-digit block
        long start = (long) Math.pow(10, d - 1);
        long index = (nn - 1) / d;    // zero-based index of the number
        int offset = (int) ((nn - 1) % d); // digit position within the number
        
        long num = start + index;
        String s = Long.toString(num);
        return s.charAt(offset) - '0';
    }
}