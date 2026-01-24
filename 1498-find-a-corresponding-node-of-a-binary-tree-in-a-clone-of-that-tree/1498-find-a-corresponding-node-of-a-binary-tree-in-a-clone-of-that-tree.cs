public class Solution {
    public TreeNode GetTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null || cloned == null) return null;

        // If we found the target in original, return cloned node
        if (original == target) return cloned;

        // Search left subtree
        TreeNode left = GetTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;

        // Search right subtree
        return GetTargetCopy(original.right, cloned.right, target);
    }
}