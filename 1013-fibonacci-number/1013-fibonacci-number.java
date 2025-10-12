class Solution {
    public int fib(int n) {
        if (n <= 1) return n; // Base cases: F(0) = 0, F(1) = 1

        int a = 0, b = 1;     // Initialize F(0) and F(1)
        for (int i = 2; i <= n; i++) {
            int temp = a + b; // F(i) = F(i-1) + F(i-2)
            a = b;            // Move forward: a becomes F(i-1)
            b = temp;         // b becomes F(i)
        }

        return b; // Final result: F(n)
    }
}