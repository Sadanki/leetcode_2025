using System;

public class Solution {
    public void SolveSudoku(char[][] board) {
        Solve(board);
    }

    private bool Solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (IsValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (Solve(board)) return true; // recurse

                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    }

    private bool IsValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == c) return false;
            // check column
            if (board[i][col] == c) return false;
            // check 3x3 subgrid
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == c) return false;
        }
        return true;
    }
}