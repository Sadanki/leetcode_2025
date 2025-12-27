class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;

        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=9;

        int total = dp[0]+dp[1];

        for(int i =2 ; i<=n ; i++){
            int val =9;
            int available = 9;
            for(int j =1; j<i; j++){
                val = val * available;
                available--;
            }
            dp[i]= val;
            total = total +dp[i];
        }
        return total;
    }
}