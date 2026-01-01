class Solution {
    private TreeNode current;
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        current = dummy;
        inorder(root);
        return dummy.right; // leftmost node becomes new root
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        
        // Reconnect node
        node.left = null;
        current.right = node;
        current = node;
        
        inorder(node.right);
    }
}