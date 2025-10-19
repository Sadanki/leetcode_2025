class Solution {
    // Main function to find the minimum ship capacity that can deliver all packages within 'days'
    public int shipWithinDays(int[] weights, int days) {
        // Minimum possible capacity is the weight of the heaviest package
        int left = getMax(weights);       
        // Maximum possible capacity is the total weight of all packages
        int right = getSum(weights);      

        // Perform binary search between the minimum and maximum capacity
        while (left < right) {
            // Calculate the middle value between left and right (candidate capacity)
            int mid = left + (right - left) / 2;

            // Check if the ship can deliver all packages with the current mid capacity
            if (canShip(weights, days, mid)) {
                // If yes, try smaller capacities (move right down to mid)
                right = mid;
            } else {
                // If no, we need a larger capacity, so move left up to mid + 1
                left = mid + 1;
            }
        }

        // When left == right, we've found the smallest capacity that works
        return left;
    }

    // Helper function to check if it's possible to ship all packages with a given capacity in 'days'
    private boolean canShip(int[] weights, int days, int capacity) {
        int dayCount = 1; // Start with 1 day
        int currentLoad = 0; // Start with no load on the ship

        // Try to load the packages one by one
        for (int weight : weights) {
            // If adding the current package exceeds the capacity, start a new day
            if (currentLoad + weight > capacity) {
                dayCount++; // Increment the day count
                currentLoad = 0; // Reset the load for the new day
            }
            // Add the current package's weight to the current day's load
            currentLoad += weight;
        }

        // Return true if we can ship all packages within the allowed days, otherwise false
        return dayCount <= days;
    }

    // Helper function to find the maximum weight in the array (heaviest package)
    private int getMax(int[] weights) {
        int max = 0;
        for (int w : weights) max = Math.max(max, w); // Find the max weight
        return max;
    }

    // Helper function to find the total weight of all packages
    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) sum += w; // Sum up all the weights
        return sum;
    }
}
