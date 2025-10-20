class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // sqrt(0) = 0, sqrt(1) = 1

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;       // mid is a candidate
                left = mid + 1;  // try to find a larger one
            } else {
                right = mid - 1; // mid is too big
            }
        }

        return ans;
    }
}