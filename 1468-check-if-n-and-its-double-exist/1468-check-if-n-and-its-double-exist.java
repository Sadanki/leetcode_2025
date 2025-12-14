import java.util.*;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        
        for (int x : arr) {
            if (seen.contains(2 * x) || (x % 2 == 0 && seen.contains(x / 2))) {
                return true;
            }
            seen.add(x);
        }
        
        return false;
    }
}