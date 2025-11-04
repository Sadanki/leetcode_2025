class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        // Step 1: Create rows
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // Step 2: Traverse string
        int currRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);

            // Step 3: Flip direction at top/bottom
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Step 4: Move up or down
            currRow += goingDown ? 1 : -1;
        }

        // Step 5: Combine rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}