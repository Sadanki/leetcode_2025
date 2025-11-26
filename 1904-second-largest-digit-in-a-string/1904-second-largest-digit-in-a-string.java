class Solution {
    public int secondHighest(String s) {
        int largest = -1;
        int second = -1;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int d = c - '0';
                
                if (d > largest) {
                    second = largest;
                    largest = d;
                } else if (d < largest && d > second) {
                    second = d;
                }
            }
        }
        
        return second;
    }
}