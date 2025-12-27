class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for(int i =1; i<n; i++){
            int curr = nums[i];

            int tempMax = maxSoFar;

            maxSoFar = Math.max(curr, Math.max(curr * maxSoFar, curr * minSoFar));
            minSoFar = Math.min(curr, Math.min(curr * tempMax, curr * minSoFar));

            maxProduct = Math.max(maxProduct, maxSoFar);


        }
         return maxProduct;

    }
}