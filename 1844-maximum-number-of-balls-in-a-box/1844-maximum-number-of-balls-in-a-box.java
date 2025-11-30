import java.util.*;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> boxCount = new HashMap<>();
        int maxBalls = 0;
        
        for (int num = lowLimit; num <= highLimit; num++) {
            int box = digitSum(num);
            boxCount.put(box, boxCount.getOrDefault(box, 0) + 1);
            maxBalls = Math.max(maxBalls, boxCount.get(box));
        }
        
        return maxBalls;
    }
    
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}