class Solution {
    public int getMoneyAmount(int n) {
     int[][] dp = new int[n+1][n+1];
     return helper(dp, 1 , n);   
    }
    private int helper (int dp [][], int lo, int hi){
        if(lo >= hi) return 0;
        if(dp[lo][hi] != 0) return dp[lo][hi];

        int res = Integer.MAX_VALUE;
        for(int x = lo; x <= hi ; x++){
            int cost = x + Math.max(helper(dp, lo, x-1), helper(dp, x+1, hi));
            res = Math.min(res, cost);
        }
        dp[lo][hi] = res;
        return res;
    }
}