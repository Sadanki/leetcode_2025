class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    // Check right neighbor and j + 1 means “move one step to the right in the same row” - grid[i][j + 1] accesses the right neighbor and - j + 1 < cols ensures we don’t go out of bounds



                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        perimeter -= 2;
                    }

                    // Check bottom neighbor
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }
}