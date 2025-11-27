class Solution {
    public boolean checkRecord(String s) {
        // Condition 1: fewer than 2 'A'
        int absences = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absences++;
                if (absences >= 2) return false;
            }
        }
        
        // Condition 2: no "LLL"
        if (s.contains("LLL")) {
            return false;
        }
        
        return true;
    }
}