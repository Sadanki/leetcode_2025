class Solution {
    public boolean checkZeroOnes(String s) {
        int maxOnes = 0, maxZeros = 0;
        int currOnes = 0, currZeros = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                currOnes++;
                currZeros = 0;
                maxOnes = Math.max(maxOnes, currOnes);
            } else {
                currZeros++;
                currOnes = 0;
                maxZeros = Math.max(maxZeros, currZeros);
            }
        }
        
        return maxOnes > maxZeros;
    }
}