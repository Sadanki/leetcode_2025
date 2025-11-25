class Solution {
    public boolean isThree(int n) {
        int root = (int) Math.sqrt(n);
        
        // Check if n is a perfect square
        if (root * root != n) {
            return false;
        }
        
        // Check if root is prime
        if (isPrime(root)) {
            return true;
        }
        
        return false;
    }
    
    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}