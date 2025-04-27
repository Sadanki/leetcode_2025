class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Calculate the total number of subarrays containing arr[i]
            int totalSubarrays = (i + 1) * (n - i);
            
            // Calculate how many of those subarrays are of odd length
            int oddLengthSubarrays = (totalSubarrays + 1) / 2;
            
            // Add the contribution of arr[i] to the total sum
            totalSum += oddLengthSubarrays * arr[i];
        }
        
        // Return the final total sum of all odd-length subarrays
        return totalSum;
    }
}
