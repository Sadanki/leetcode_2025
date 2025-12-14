public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // avoid overflow
            int res = guess(mid);
            
            if (res == 0) {
                return mid; // found the number
            } else if (res < 0) {
                high = mid - 1; // number is lower
            } else {
                low = mid + 1; // number is higher
            }
        }
        
        return -1; // should never reach here
    }
}