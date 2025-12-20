import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        
        for (int house : houses) {
            // binary search to find closest heater
            int idx = Arrays.binarySearch(heaters, house);
            
            if (idx >= 0) {
                // house exactly at heater position
                continue;
            } else {
                idx = -(idx + 1); // insertion point
                int dist1 = (idx - 1 >= 0) ? house - heaters[idx - 1] : Integer.MAX_VALUE;
                int dist2 = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;
                int closest = Math.min(dist1, dist2);
                radius = Math.max(radius, closest);
            }
        }
        
        return radius;
    }
}