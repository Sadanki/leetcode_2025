public class Solution {
    public int ProjectionArea(int[][] grid) {
        int n = grid.Length;
        int m = grid[0].Length;

        int top=0, front =0, side=0;

        for(int i =0; i<n; i++){
            int rowMax = 0;
            for(int j = 0; j<m ; j++){
                if(grid[i][j]>0) top++;
                rowMax = Math.Max(rowMax, grid[i][j]);
            }
            front = front + rowMax;
        }

        for(int j =0; j<m ; j++){
            int colMax =0;
            for(int i =0; i<n; i++){
                colMax = Math.Max(colMax, grid[i][j]);
            }
            side = side + colMax;
        }
        return top + front+side;
    }
}