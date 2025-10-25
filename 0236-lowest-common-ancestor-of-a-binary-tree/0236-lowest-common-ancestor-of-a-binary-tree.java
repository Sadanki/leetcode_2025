class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches p or q
        if (root == null || root == p || root == q) return root;

        // Recursive calls
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Ternary logic to decide LCA
        return left != null && right != null ? root :
               left != null ? left : right;
    }
}