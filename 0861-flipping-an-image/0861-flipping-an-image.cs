public class Solution {
    public int[][] FlipAndInvertImage(int[][] image) {
        int rows = image.Length;
        int cols = image[0].Length;

        for (int i = 0; i < rows; i++) {
            // Flip horizontally and invert in one pass
            for (int j = 0; j < (cols + 1) / 2; j++) {
                // Swap left and right while inverting
                int temp = image[i][j] ^ 1; // invert left
                image[i][j] = image[i][cols - 1 - j] ^ 1; // invert right
                image[i][cols - 1 - j] = temp;
            }
        }

        return image;
    }
}