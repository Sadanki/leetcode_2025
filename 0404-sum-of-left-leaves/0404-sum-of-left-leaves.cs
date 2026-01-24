public class Solution {
    public int SumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return Dfs(root);
    }

    private int Dfs(TreeNode node) {
        if (node == null) return 0;

        int sum = 0;

        // Check if left child exists and is a leaf
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }

        // Recurse into left and right children
        sum += Dfs(node.left);
        sum += Dfs(node.right);

        return sum;
    }
}