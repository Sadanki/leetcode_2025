class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;

        int count = 0;
        long product =1;
        int left =0;

        for( int right = 0 ; right < nums.length; right ++){
            product = product * nums[right];

            while (product >=k  && left <= right){
                product /= nums[left];
                left ++;
            }
            count = count +(right -left+ 1);
        }
        return count;
    }
}