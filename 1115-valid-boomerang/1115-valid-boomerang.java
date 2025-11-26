class Solution {
    public boolean isBoomerang(int[][] points) {
        // Step 1: Check distinctness
        if (isSame(points[0], points[1]) || 
            isSame(points[1], points[2]) || 
            isSame(points[0], points[2])) {
            return false;
        }
        
        // Step 2: Check collinearity using cross product
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        
        return (y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1);
    }
    
    private boolean isSame(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }
}