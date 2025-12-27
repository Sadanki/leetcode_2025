import java.util.HashMap;
import java.util.Map;

class Solution {
    public int integerReplacement(int n) {
        return (int) helper((long) n, new HashMap<>());
    }

    private long helper(long n, Map<Long, Long> memo) {
        if (n == 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        long res;
        if ((n & 1L) == 0) {
            // even: n / 2
            res = 1 + helper(n >> 1, memo);
        } else {
            // odd: choose min between n-1 and n+1 (no overflow with long)
            res = 1 + Math.min(helper(n - 1, memo), helper(n + 1, memo));
        }

        memo.put(n, res);
        return res;
    }
}