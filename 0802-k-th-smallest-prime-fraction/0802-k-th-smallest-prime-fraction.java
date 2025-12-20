import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        
        // Min-heap storing fractions as (value, numerator index, denominator index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare((double)arr[a[0]] / arr[a[1]], (double)arr[b[0]] / arr[b[1]])
        );
        
        // Initialize heap with fractions having numerator arr[0]
        for (int j = 1; j < n; j++) {
            pq.offer(new int[]{0, j}); // fraction arr[0]/arr[j]
        }
        
        // Extract k-1 smallest fractions
        for (int count = 0; count < k - 1; count++) {
            int[] frac = pq.poll();
            int i = frac[0], j = frac[1];
            
            // Move numerator forward (next fraction with same denominator)
            if (i + 1 < j) {
                pq.offer(new int[]{i + 1, j});
            }
        }
        
        // k-th smallest fraction
        int[] result = pq.poll();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}