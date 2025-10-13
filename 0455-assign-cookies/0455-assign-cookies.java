import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Step 1: Sort both arrays
        Arrays.sort(g); // greed factors
        Arrays.sort(s); // cookie sizes

        int child = 0;  // pointer for children
        int cookie = 0; // pointer for cookies

        // Step 2: Try to satisfy each child with the smallest possible cookie
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // Cookie satisfies the child's greed
                child++;
            }
            // Move to next cookie either way
            cookie++;
        }

        // Step 3: Return number of content children
        return child;
    }
}