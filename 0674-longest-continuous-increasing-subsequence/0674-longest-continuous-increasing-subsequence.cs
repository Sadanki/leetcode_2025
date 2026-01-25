public class Solution {
    public int FindLengthOfLCIS(int[] nums) {
        if(nums.Length == 0) return 0;

        int maxLength=1;
        int currentLength =1;

        for(int i =1; i< nums.Length; i++){
            if(nums[i]> nums[i-1]){
                currentLength++;
                maxLength = Math.Max(maxLength, currentLength);
            }else{
                currentLength=1;
            }
        }
        return maxLength;
    }
}