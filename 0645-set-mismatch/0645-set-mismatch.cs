using System;
using System.Collections.Generic;

public class Solution {
    public int[] FindErrorNums(int[] nums) {
        int n = nums.Length;
        var seen = new HashSet<int>();
        int duplicate = -1;

        // Step 1: Find duplicate
        foreach (int num in nums) {
            if (seen.Contains(num)) {
                duplicate = num;
            }
            seen.Add(num);
        }

        // Step 2: Find missing
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (!seen.Contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[] { duplicate, missing };
    }
}