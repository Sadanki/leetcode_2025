public class Solution {
    public bool EvaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            // Leaf node: return true if 1, false if 0
            return root.val == 1;
        }

        // Non-leaf node
        if (root.val == 2) {
            // OR operation
            return EvaluateTree(root.left) || EvaluateTree(root.right);
        } else {
            // AND operation (val == 3)
            return EvaluateTree(root.left) && EvaluateTree(root.right);
        }
    }
}