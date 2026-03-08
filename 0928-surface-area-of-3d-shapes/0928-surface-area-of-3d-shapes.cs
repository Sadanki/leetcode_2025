public class Solution {
    public int SurfaceArea(int[][] grid) {
      int n = grid.Length;
      int m = grid[0].Length;
      int area =0;

      for(int i =0; i<n ; i++){
        for(int j =0; j<m; j++){
            int h = grid[i][j];
            if(h>0){
            area = area +2;
            area =  area + h -(i>0? Math.Min(h, grid[i-1][j]) :0);
            area = area + h -(i< n-1? Math.Min(h , grid[i+1][j]): 0);
            area = area + h -(j >0? Math.Min(h, grid[i][j-1]): 0);
            area = area +h -(j<m-1? Math.Min(h, grid[i][j+1]): 0);
            }
        }
      } 
      return area; 
    }
}