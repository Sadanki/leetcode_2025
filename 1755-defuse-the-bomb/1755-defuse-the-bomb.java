import java.util.stream.IntStream;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) return result;

        for (int i = 0; i < n; i++) {
            final int idx = i; 
            int sum = (k > 0)
                ? IntStream.rangeClosed(1, k)
                        .map(j -> code[(idx + j) % n])
                        .sum()
                : IntStream.rangeClosed(1, -k)
                        .map(j -> code[(idx - j + n) % n])
                        .sum();

            result[i] = sum;
        }

        return result;
    }
}