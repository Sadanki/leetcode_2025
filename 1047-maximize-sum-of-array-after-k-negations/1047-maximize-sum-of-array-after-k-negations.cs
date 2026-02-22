public class Solution {
    public int LargestSumAfterKNegations(int[] nums, int k) {
        Array.Sort(nums, (a, b) => Math.Abs(b) - Math.Abs(a));

        for(int i = 0; i < nums.Length && k > 0; i++) {  
            if(nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if(k % 2 != 0) {
            nums[nums.Length - 1] = -nums[nums.Length - 1]; 
        }

        int sum = 0;
        foreach(int n in nums) sum += n;
        return sum;
    }
}