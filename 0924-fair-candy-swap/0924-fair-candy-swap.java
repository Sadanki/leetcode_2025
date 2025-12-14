import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;
        
        int delta = (sumA - sumB) / 2; // difference Alice needs to give
        
        Set<Integer> setB = new HashSet<>();
        for (int b : bobSizes) setB.add(b);
        
        for (int a : aliceSizes) {
            int target = a - delta;
            if (setB.contains(target)) {
                return new int[]{a, target};
            }
        }
        
        return new int[0]; // guaranteed at least one answer exists
    }
}