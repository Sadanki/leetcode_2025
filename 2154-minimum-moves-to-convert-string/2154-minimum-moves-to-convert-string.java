class Solution {
    public int minimumMoves(String s) {
        int moves = 0;
        int i = 0;
        
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                // Apply a move starting here
                moves++;
                i += 3; // skip next 3 characters
            } else {
                i++; // move to next character
            }
        }
        
        return moves;
    }
}