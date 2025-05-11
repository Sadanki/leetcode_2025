class Solution {
    public boolean isBalanced(TreeNode root) {
        // If checkHeight returns -1, the tree is not balanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root) {
        if (root == null) {
            return 0; // Base case: height of empty subtree is 0
        }

        // Recursively check the height of left subtree
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }

        // Recursively check the height of right subtree
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Unbalanced at this node
        }

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
