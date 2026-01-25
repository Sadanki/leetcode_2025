using System;
using System.Collections.Generic;

public class Solution {
    public string[] FindRestaurant(string[] list1, string[] list2) {
        // Step 1: Map each restaurant in list1 to its index
        var map = new Dictionary<string, int>();
        for (int i = 0; i < list1.Length; i++) {
            map[list1[i]] = i;
        }

        // Step 2: Traverse list2 and check for common restaurants
        var result = new List<string>();
        int minSum = int.MaxValue;

        for (int j = 0; j < list2.Length; j++) {
            if (map.ContainsKey(list2[j])) {
                int sum = j + map[list2[j]];

                if (sum < minSum) {
                    result.Clear();          // new minimum found
                    result.Add(list2[j]);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.Add(list2[j]);   // same minimum, add to result
                }
            }
        }

        // Step 3: Return result as array
        return result.ToArray();
    }
}