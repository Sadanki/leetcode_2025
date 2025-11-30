import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int target = (int)(total % p);
        if (target == 0) return 0;  // already divisible
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // prefix sum before start
        long prefix = 0;
        int res = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = (int)(prefix % p);
            int need = (mod - target + p) % p;
            
            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
            map.put(mod, i);
        }
        
        return res == nums.length ? -1 : res;
    }
}