class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid; // number of papers with citations >= citations[mid]
            
            if (citations[mid] == h) {
                return h; // exact match
            } else if (citations[mid] < h) {
                left = mid + 1; // need more citations, move right
            } else {
                right = mid - 1; // citations[mid] too large, move left
            }
        }
        
        return n - left;
    }
}