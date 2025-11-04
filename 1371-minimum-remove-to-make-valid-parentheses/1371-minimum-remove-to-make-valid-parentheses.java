class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidIndices = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // First pass: identify invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // track unmatched '('
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // match found
                } else {
                    invalidIndices.add(i); // unmatched ')'
                }
            }
        }

        // Add remaining unmatched '(' to invalid set
        while (!stack.isEmpty()) {
            invalidIndices.add(stack.pop());
        }

        // Second pass: build valid string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}