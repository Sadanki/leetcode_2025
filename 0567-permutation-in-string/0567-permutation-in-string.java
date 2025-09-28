class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26]; // frequency of s1
        int[] s2Count = new int[26]; // frequency of current window in s2

        // Fill s1Count and first window of s2Count
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Compare first window
        if (Arrays.equals(s1Count, s2Count)) return true;

        // Slide the window
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add new character to window
            s2Count[s2.charAt(i) - 'a']++;
            // Remove old character from window
            s2Count[s2.charAt(i - s1.length()) - 'a']--;

            // Compare window with s1
            if (Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}