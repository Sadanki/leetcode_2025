class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find min and max
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Compute gcd using Euclidean algorithm
        return gcd(min, max);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}