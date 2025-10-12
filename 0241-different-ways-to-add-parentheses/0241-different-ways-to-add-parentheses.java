import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expr, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expr)) return memo.get(expr);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expr.substring(0, i);
                String right = expr.substring(i + 1);

                List<Integer> leftResults = compute(left, memo);
                List<Integer> rightResults = compute(right, memo);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') result.add(l + r);
                        else if (c == '-') result.add(l - r);
                        else if (c == '*') result.add(l * r);
                    }
                }
            }
        }

        // If no operator found, it's a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expr));
        }

        memo.put(expr, result);
        return result;
    }
}