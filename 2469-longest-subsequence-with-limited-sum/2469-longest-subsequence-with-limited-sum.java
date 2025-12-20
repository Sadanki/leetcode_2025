import java.util.*;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums); // Step 1: sort nums
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i]; // Step 2: prefix sums
        }
        
        int m = queries.length;
        int[] answer = new int[m];
        
        for (int i = 0; i < m; i++) {
            int q = queries[i];
            // Step 3: binary search
            int idx = upperBound(prefix, q);
            answer[i] = idx; 
        }
        
        return answer;
    }
    
    // Custom upperBound: returns largest index+1 where prefix[index] <= target
    private int upperBound(int[] prefix, int target) {
        int left = 0, right = prefix.length - 1;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] <= target) {
                ans = mid + 1; // valid subsequence size
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}