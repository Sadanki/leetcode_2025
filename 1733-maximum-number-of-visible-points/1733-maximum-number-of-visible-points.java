import java.util.*;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameLocationCount = 0;
        List<Double> angles = new ArrayList<>();

        int posx = location.get(0);
        int posy = location.get(1);

        // Step 1: Separate points at location and compute angles
        for (List<Integer> p : points) {
            int x = p.get(0), y = p.get(1);
            if (x == posx && y == posy) {
                sameLocationCount++;
            } else {
                double theta = Math.toDegrees(Math.atan2(y - posy, x - posx));
                angles.add(theta);
            }
        }

        // Step 2: Sort angles
        Collections.sort(angles);

        // Step 3: Duplicate angles for wrap-around
        List<Double> extended = new ArrayList<>(angles);
        for (double a : angles) {
            extended.add(a + 360.0);
        }

        // Step 4: Sliding window
        int maxVisible = 0;
        int left = 0;
        for (int right = 0; right < extended.size(); right++) {
            while (extended.get(right) - extended.get(left) > angle) {
                left++;
            }
            maxVisible = Math.max(maxVisible, right - left + 1);
        }

        return sameLocationCount + maxVisible;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample input
        List<List<Integer>> points = Arrays.asList(
            Arrays.asList(2, 1),
            Arrays.asList(2, 2),
            Arrays.asList(3, 3)
        );
        int angle = 90;
        List<Integer> location = Arrays.asList(1, 1);

        // Call the method
        int result = sol.visiblePoints(points, angle, location);
        System.out.println("Maximum visible points: " + result); // Expected output: 3
    }
}