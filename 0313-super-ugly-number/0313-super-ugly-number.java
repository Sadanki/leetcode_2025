class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] ugly = new int[n];
        ugly[0] = 1;

        int[] idx = new int[k];
        long[] val = new long[k]; // use long to avoid overflow in candidates

        for (int i = 0; i < k; i++) {
            val[i] = primes[i]; // primes[i] * ugly[0]
        }

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (val[j] < next) next = val[j];
            }

            // next fits in 32-bit per problem guarantee
            ugly[i] = (int) next;

            // advance all pointers that produced 'next'
            for (int j = 0; j < k; j++) {
                if (val[j] == next) {
                    idx[j]++;
                    // compute next candidate with long to avoid overflow
                    val[j] = (long) ugly[idx[j]] * (long) primes[j];
                }
            }
        }

        return ugly[n - 1];
    }
}