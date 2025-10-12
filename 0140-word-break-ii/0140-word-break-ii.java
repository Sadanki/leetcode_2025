import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // faster lookup
        Map<String, List<String>> memo = new HashMap<>(); // memoization
        return backtrack(s, wordSet, memo);
    }

    private List<String> backtrack(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();

        if (wordSet.contains(s)) result.add(s); // whole string is a word

        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (!wordSet.contains(prefix)) continue;

            String suffix = s.substring(i);
            List<String> suffixBreaks = backtrack(suffix, wordSet, memo);

            for (String sentence : suffixBreaks) {
                result.add(prefix + " " + sentence);
            }
        }

        memo.put(s, result);
        return result;
    }
}