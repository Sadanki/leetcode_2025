class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int countA = 0; // mismatches if pattern starts with '0'
        int countB = 0; // mismatches if pattern starts with '1'
        
        for (int i = 0; i < n; i++) {
            char expectedA = (i % 2 == 0) ? '0' : '1'; // pattern "0101..."
            char expectedB = (i % 2 == 0) ? '1' : '0'; // pattern "1010..."
            
            if (s.charAt(i) != expectedA) countA++;
            if (s.charAt(i) != expectedB) countB++;
        }
        
        return Math.min(countA, countB);
    }
}