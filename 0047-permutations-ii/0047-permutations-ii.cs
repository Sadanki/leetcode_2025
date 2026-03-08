public class Solution {
    public IList<IList<int>> PermuteUnique(int[] nums) {
        var result = new List<IList<int>>();
        Array.Sort(nums); // sort to handle duplicates
        bool[] used = new bool[nums.Length];
        Backtrack(nums, new List<int>(), used, result);
        return result;
    }

    private void Backtrack(int[] nums, List<int> current, bool[] used, IList<IList<int>> result) {
        if (current.Count == nums.Length) {
            result.Add(new List<int>(current));
            return;
        }

        for (int i = 0; i < nums.Length; i++) {
            // Skip if already used
            if (used[i]) continue;

            // Skip duplicates: only use the first unused duplicate
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.Add(nums[i]);

            Backtrack(nums, current, used, result);

            // backtrack
            current.RemoveAt(current.Count - 1);
            used[i] = false;
        }
    }
}