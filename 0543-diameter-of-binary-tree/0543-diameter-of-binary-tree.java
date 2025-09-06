class Solution {
    private int maxDiameter = 0;  // global variable to store result
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
    
    // helper function to calculate height of a node
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);
        
        // update diameter at this node
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        // return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
