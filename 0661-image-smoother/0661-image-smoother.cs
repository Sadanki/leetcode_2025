using System;

public class Solution {
    public int[][] ImageSmoother(int[][] img) {
        int m = img.Length;
        int n = img[0].Length;
        int[][] result = new int[m][];
        
        for (int i = 0; i < m; i++) {
            result[i] = new int[n];
            for (int j = 0; j < n; j++) {
                int sum = 0, count = 0;
                
                // Check all neighbors in 3x3 block
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c];
                            count++;
                        }
                    }
                }
                
                result[i][j] = sum / count; // integer division
            }
        }
        
        return result;
    }
}