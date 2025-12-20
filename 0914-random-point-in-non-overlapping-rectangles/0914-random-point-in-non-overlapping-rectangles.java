import java.util.*;

class Solution {
    private int[][] rects;
    private int[] prefix; // prefix sum of areas
    private Random rand;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.prefix = new int[rects.length];
        this.rand = new Random();

        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int a = rects[i][0], b = rects[i][1], x = rects[i][2], y = rects[i][3];
            int area = (x - a + 1) * (y - b + 1);
            sum += area;
            prefix[i] = sum;
        }
    }

    public int[] pick() {
        // Step 1: pick random index in [1, totalPoints]
        int target = rand.nextInt(prefix[rects.length - 1]) + 1;

        // Step 2: binary search to find rectangle
        int idx = Arrays.binarySearch(prefix, target);
        if (idx < 0) idx = -idx - 1;

        int[] rect = rects[idx];
        int a = rect[0], b = rect[1], x = rect[2], y = rect[3];

        // Step 3: pick random point inside rect
        int randX = a + rand.nextInt(x - a + 1);
        int randY = b + rand.nextInt(y - b + 1);

        return new int[]{randX, randY};
    }
}