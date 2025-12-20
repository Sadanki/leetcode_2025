import java.util.*;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // Convert List to array for easier handling
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nums.get(i);
        
        Arrays.sort(arr); // Step 1: sort
        
        int count = 0;
        int l = 0, r = n - 1;
        
        // Step 2: two-pointer technique
        while (l < r) {
            if (arr[l] + arr[r] < target) {
                count =count + (r - l); // all pairs with arr[l] and elements between l+1..r
                l++;
            } else {
                r--;
            }
        }
        
        return count;
    }
}