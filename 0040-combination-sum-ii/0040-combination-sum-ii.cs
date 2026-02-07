public class Solution {
    public IList<IList<int>> CombinationSum2(int[] candidates, int target) {
        Array.Sort(candidates); // Step 1: sort
        var results = new List<IList<int>>();
        Backtrack(candidates, target, 0, new List<int>(), results);
        return results;
    }

    private void Backtrack(int[] candidates, int target, int start, List<int> current, IList<IList<int>> results) {
        if (target == 0) {
            results.Add(new List<int>(current)); // Found valid combination
            return;
        }

        for (int i = start; i < candidates.Length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // Stop if number is too large
            if (candidates[i] > target) break;

            current.Add(candidates[i]);
            Backtrack(candidates, target - candidates[i], i + 1, current, results); // i+1 ensures each number used once
            current.RemoveAt(current.Count - 1); // backtrack
        }
    }
}