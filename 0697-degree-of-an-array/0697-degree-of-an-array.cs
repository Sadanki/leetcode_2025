public class Solution {
    public int FindShortestSubArray(int[] nums) {
        Dictionary<int, int> count = new Dictionary<int, int>();
        Dictionary<int, int> first = new Dictionary<int, int>();
        Dictionary<int, int> last = new Dictionary<int, int>();

        for (int i = 0; i < nums.Length; i++) {
            int num = nums[i];
            if (!first.ContainsKey(num)) {
                first[num] = i;
            }
            last[num] = i;

            if (!count.ContainsKey(num)) {
                count[num] = 0;
            }
            count[num]++;
        }

        int degree = count.Values.Max();
        int minLength = nums.Length;

        foreach (var kvp in count) {
            if (kvp.Value == degree) {
                int num = kvp.Key;
                int length = last[num] - first[num] + 1;
                minLength = Math.Min(minLength, length);
            }
        }

        return minLength;
    }
}