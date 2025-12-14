class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (letters[mid] <= target) {
                low = mid + 1; // move right
            } else {
                high = mid - 1; // move left
            }
        }
        
        // If low goes out of bounds, wrap around to first element
        return letters[low % letters.length];
    }
}