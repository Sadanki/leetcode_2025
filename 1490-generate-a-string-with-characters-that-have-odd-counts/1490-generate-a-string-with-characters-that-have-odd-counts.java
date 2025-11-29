class Solution {
    public String generateTheString(int n) {
        if (n % 2 == 1) {
            // odd n → just repeat 'a'
            return "a".repeat(n);
        } else {
            // even n → (n-1) 'a's + 1 'b'
            return "a".repeat(n - 1) + "b";
        }
    }
}