public class Solution {
    public bool IsToeplitzMatrix(int[][] matrix) {
        int rows = matrix.Length;
        int cols = matrix[0].Length;

        // Start from row = 1 and col = 1 because row 0 and col 0
        // don't have top-left neighbors
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false; // mismatch found
                }
            }
        }

        return true; // all diagonals matched
    }
}