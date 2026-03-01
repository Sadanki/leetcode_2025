public class Solution {
    public int CountPrefixSuffixPairs(string[] words) {
        int count = 0;
        int n = words.Length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[j].StartsWith(words[i]) && words[j].EndsWith(words[i])) {
                    count++;
                }
            }
        }

        return count;
    }
}