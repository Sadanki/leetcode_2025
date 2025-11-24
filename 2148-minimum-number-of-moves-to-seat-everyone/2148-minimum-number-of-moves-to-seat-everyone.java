import java.util.*;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // Sort both arrays
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int moves = 0;
        // Pair each student with the corresponding seat
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        
        return moves;
    }
}