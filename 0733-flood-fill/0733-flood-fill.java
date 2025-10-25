class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int originalColor = image[sr][sc];
       if(originalColor == color) return image; 

       dfs(image, sr, sc, originalColor, color);
       return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor){
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if(image[r][c] !=originalColor) return;

        image[r][c]=newColor;

        dfs(image, r+1, c, originalColor, newColor);
        dfs(image, r-1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor); // right
        dfs(image, r, c - 1, originalColor, newColor); // left

    }
}