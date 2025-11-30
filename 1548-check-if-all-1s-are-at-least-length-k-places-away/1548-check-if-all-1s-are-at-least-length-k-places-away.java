class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1; // track last seen 1
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex <= k) {
                    return false; // violation found
                }
                lastIndex = i; // update last seen 1
            }
        }
        
        return true; // no violations
    }
}