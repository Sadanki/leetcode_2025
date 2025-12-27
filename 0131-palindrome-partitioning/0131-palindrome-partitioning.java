import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        // Precompute palindrome substrings
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0, dp);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> current, String s, int start, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                current.add(s.substring(start, end + 1));
                backtrack(result, current, s, end + 1, dp);
                current.remove(current.size() - 1);
            }
        }
    }
}