public class Solution {
    public string LargestNumber(int[] nums) {

        // STEP 1: Convert to strings + custom sort
        string[] strs = Array.ConvertAll(nums, x => x.ToString());

        Array.Sort(strs, (a, b) => {
            string ab = a + b;
            string ba = b + a;
            return ba.CompareTo(ab);  // descending: larger combo first
        });

        // STEP 2: Join all parts together
        string result = string.Join("", strs);

        // STEP 3: Edge case — all zeros
        if (result[0] == '0') return "0";

        // STEP 4: Return
        return result;
    }
}