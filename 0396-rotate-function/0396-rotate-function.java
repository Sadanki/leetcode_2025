class Solution {
    public int maxRotateFunction(int[] nums) {
      int n =nums.length;
      long sum =0;
      long f0 =0;

      for(int i =0; i <n ; i++){
        sum = sum + nums[i];
        f0 = f0 + (long) i * nums[i];
      }  

      long max =f0;
      long fk = f0;

      for( int k =1; k<n ; k++){
        fk = fk + sum - (long) n * nums[n-k];
        max = Math.max(max, fk);
      }
      return (int) max;
    }
}