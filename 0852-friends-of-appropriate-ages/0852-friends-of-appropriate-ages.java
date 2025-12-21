import java.util.*;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int age = ages[i];
            if (age < 15) continue; // no valid requests possible

            // lower bound: first index where age[y] > 0.5 * age + 7
            int low = lowerBound(ages, (int)(0.5 * age + 7));
            // upper bound: last index where age[y] <= age
            int high = upperBound(ages, age);

            // count of valid people in range [low, high)
            total += (high - low - 1); // subtract 1 to exclude self
        }

        return total;
    }

    // Binary search: first index > target
    private int lowerBound(int[] ages, int target) {
        int l = 0, r = ages.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // Binary search: first index > target (so result is count of <= target)
    private int upperBound(int[] ages, int target) {
        int l = 0, r = ages.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (ages[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}