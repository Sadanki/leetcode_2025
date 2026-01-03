class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: empty needle
        if (needle.length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        // Slide over haystack
        for (int i = 0; i <= n - m; i++) {
            // Check substring match
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        // Not found
        return -1;
    }
}