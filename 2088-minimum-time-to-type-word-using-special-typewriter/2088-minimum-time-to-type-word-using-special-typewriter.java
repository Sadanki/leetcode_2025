class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        char curr = 'a';  // pointer starts at 'a'
        
        for (char c : word.toCharArray()) {
            int diff = Math.abs(curr - c);
            int move = Math.min(diff, 26 - diff); // shortest circular distance
            time += move + 1; // move + type
            curr = c; // update pointer
        }
        
        return time;
    }
}