public class Solution {
    public string LongestNiceSubstring(string s) {
        int n = s.Length;
        string result = "";

        for (int len = n; len >= 2; len--) {
            for (int start = 0; start + len <= n; start++) {
                string sub = s.Substring(start, len);
                if (IsNice(sub)) {
                    return sub; // longest found first
                }
            }
        }
        return result;
    }

    private bool IsNice(string sub) {
        HashSet<char> set = new HashSet<char>(sub);
        foreach (char c in set) {
            if (char.IsLower(c) && !set.Contains(char.ToUpper(c))) return false;
            if (char.IsUpper(c) && !set.Contains(char.ToLower(c))) return false;
        }
        return true;
    }
}