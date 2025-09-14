class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;  // Base case: empty tree
        
        // Recursively flatten both subtrees
        flatten(root.left);
        flatten(root.right);
        
        // Store the right subtree before we modify it
        TreeNode rightSubtree = root.right;
        
        // Move the flattened left subtree to the right side
        root.right = root.left;
        root.left = null;  // Important: set left to null as required
        
        // Traverse to the end of the new right subtree (which was left subtree)
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // Attach the original right subtree at the end
        current.right = rightSubtree;
    }
}