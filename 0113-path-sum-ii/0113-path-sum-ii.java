class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        // Choose the current node
        path.add(node.val);

        // If it's a leaf and sum matches → add to result
        if (node.left == null && node.right == null && remaining == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            // Recurse on children
            dfs(node.left, remaining - node.val, path, result);
            dfs(node.right, remaining - node.val, path, result);
        }

        // Backtrack (remove last element)
        path.remove(path.size() - 1);
    }
}
