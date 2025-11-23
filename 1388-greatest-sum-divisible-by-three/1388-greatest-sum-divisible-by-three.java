import java.util.*;

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();
        
        // Step 1: Calculate sum and collect remainders
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) rem1.add(num);
            else if (num % 3 == 2) rem2.add(num);
        }
        
        // Step 2: Sort remainder lists to easily pick smallest
        Collections.sort(rem1);
        Collections.sort(rem2);
        
        // Step 3: Adjust sum if needed
        if (sum % 3 == 0) return sum;
        else if (sum % 3 == 1) {
            int option1 = rem1.size() >= 1 ? sum - rem1.get(0) : 0;
            int option2 = rem2.size() >= 2 ? sum - rem2.get(0) - rem2.get(1) : 0;
            return Math.max(option1, option2);
        } else { // sum % 3 == 2
            int option1 = rem2.size() >= 1 ? sum - rem2.get(0) : 0;
            int option2 = rem1.size() >= 2 ? sum - rem1.get(0) - rem1.get(1) : 0;
            return Math.max(option1, option2);
        }
    }
}