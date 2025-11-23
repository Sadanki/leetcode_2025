class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0;
        int profit = 0;
        int maxProfit = 0;
        int bestRotation = -1;  // initialize to -1
        int rotations = 0;

        // Process arrivals
        for (int i = 0; i < customers.length; i++) {
            waiting += customers[i];
            int boarded = Math.min(4, waiting);
            waiting -= boarded;

            rotations++;
            profit += boarded * boardingCost - runningCost;

            if (profit > maxProfit) {
                maxProfit = profit;
                bestRotation = rotations;
            }
        }

        // Process remaining waiting customers
        while (waiting > 0) {
            int boarded = Math.min(4, waiting);
            waiting -= boarded;

            rotations++;
            profit += boarded * boardingCost - runningCost;

            if (profit > maxProfit) {
                maxProfit = profit;
                bestRotation = rotations;
            }
        }

        return maxProfit > 0 ? bestRotation : -1;
    }
}