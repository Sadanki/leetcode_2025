class Solution {
    private int diameter = 0;  // Variable to store the diameter of the tree

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);  // Start calculating the height of the tree
        return diameter;  // Return the diameter of the tree
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;  // Base case: if the node is null, return height 0
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        // Update the diameter (max path length between any two nodes)
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
