class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle edge cases: null matrix, empty matrix, or matrix with empty rows
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;     // Total number of rows in the matrix
        int cols = matrix[0].length;  // Total number of columns in the matrix
        
        // START FROM TOP-RIGHT CORNER STRATEGY:
        // This position gives us the optimal starting point because:
        // - Moving left → decreases value (columns are sorted)
        // - Moving down → increases value (rows are sorted)
        int row = 0;          // Start at first row (top)
        int col = cols - 1;   // Start at last column (right)
        
        // Search while we're within matrix boundaries
        while (row < rows && col >= 0) {
            int current = matrix[row][col];  // Get current element value
            
            if (current == target) {
                // FOUND: Current element matches target
                return true;
            } else if (current > target) {
                // CURRENT TOO BIG: 
                // All elements in this COLUMN below current are even larger (column sorted top to bottom)
                // So we can eliminate entire current column by moving LEFT
                col--;
            } else {
                // CURRENT TOO SMALL:
                // All elements in this ROW to the left are even smaller (row sorted left to right)
                // So we can eliminate entire current row by moving DOWN
                row++;
            }
        }
        
        // If we exit the loop, it means we searched the entire possible area
        // and didn't find the target
        return false;
    }
}