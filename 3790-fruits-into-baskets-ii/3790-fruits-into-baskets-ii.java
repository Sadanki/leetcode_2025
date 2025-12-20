class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n]; // track basket usage
        int unplaced = 0;
        
        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true; // mark basket as filled
                    placed = true;
                    break; // stop at leftmost valid basket
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        
        return unplaced;
    }
}