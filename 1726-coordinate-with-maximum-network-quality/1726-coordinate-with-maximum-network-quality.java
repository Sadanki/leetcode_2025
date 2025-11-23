class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX = 0, maxY = 0;
        for (int[] tower : towers) {
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
        }
        
        int bestX = 0, bestY = 0;
        int maxQuality = 0;
        
        for (int x = 0; x <= maxX; x++) {
            for (int y = 0; y <= maxY; y++) {
                int quality = 0;
                for (int[] tower : towers) {
                    int dx = tower[0] - x;
                    int dy = tower[1] - y;
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    if (dist <= radius) {
                        quality += (int)(tower[2] / (1 + dist));
                    }
                }
                
                if (quality > maxQuality || 
                   (quality == maxQuality && (x < bestX || (x == bestX && y < bestY)))) {
                    maxQuality = quality;
                    bestX = x;
                    bestY = y;
                }
            }
        }
        
        return new int[]{bestX, bestY};
    }
}