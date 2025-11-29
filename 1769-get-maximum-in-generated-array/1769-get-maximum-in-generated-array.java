class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;

        for (int i = 1; 2 * i <= n || 2 * i + 1 <= n; i++) {
            int even = 2 * i;
            if (even <= n) {
                nums[even] = nums[i];
                if (nums[even] > max) max = nums[even];
            }
            int odd = even+1;
            if(odd<=n){
                nums[odd]= nums[i] + nums[i+1];
                if(nums[odd]> max) max = nums[odd];
            }
        }
        return max;
    }
}
