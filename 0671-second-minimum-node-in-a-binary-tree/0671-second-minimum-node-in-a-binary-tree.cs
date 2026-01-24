public class Solution {
    public int FindSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return DFS(root, root.val);
    }

    private int DFS(TreeNode node, int minVal) {
        if (node == null) return -1;

        // If current node value is greater than minVal, it's a candidate
        if (node.val > minVal) return node.val;

        // Otherwise, search both children
        int left = DFS(node.left, minVal);
        int right = DFS(node.right, minVal);

        if (left == -1) return right;
        if (right == -1) return left;
        return Math.Min(left, right);
    }
}