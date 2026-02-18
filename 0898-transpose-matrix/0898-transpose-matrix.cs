public class Solution {
    public int[][] Transpose(int[][] matrix) {
      int rows = matrix.Length;
      int cols = matrix[0].Length;

      int[][] result = new int[cols][];
      for(int i =0 ; i<cols; i++){
        result[i]= new int[rows];
      }  

      for(int i =0; i< rows; i++){
        for(int j =0; j<cols; j++){
            result[j][i]= matrix[i][j];
        }
      }
      return result;
    }
}