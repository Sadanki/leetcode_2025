class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image; // No change needed

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary check
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;

        // Only fill if the current pixel matches the original color
        if (image[r][c] != originalColor) return;

        // Fill the pixel
        image[r][c] = newColor;

        // Recursively fill adjacent pixels
        dfs(image, r + 1, c, originalColor, newColor); // down
        dfs(image, r - 1, c, originalColor, newColor); // up
        dfs(image, r, c + 1, originalColor, newColor); // right
        dfs(image, r, c - 1, originalColor, newColor); // left
    }
}