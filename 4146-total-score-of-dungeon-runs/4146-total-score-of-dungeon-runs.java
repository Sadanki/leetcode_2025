import java.util.*;

class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] prefix = new long[n + 1]; // prefixDamage
        
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + damage[i - 1];
        }
        
        long total = 0;
        
        for (int i = 1; i <= n; i++) {
            long need = prefix[i] + requirement[i - 1] - hp;
            
            // binary search for smallest k with prefix[k] >= need
            int k = lowerBound(prefix, need);
            
            // valid starts are j in [k+1, i]
            if (k <= i - 1) {
                total += (i - k);
            }
        }
        
        return total;
    }
    
    // standard lower_bound (first index with value >= target)
    private int lowerBound(long[] arr, long target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}