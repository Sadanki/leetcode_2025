class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: empty tree or found the node
        if (root == null || root.val == val) {
            return root;
        }
        
        // Search left or right depending on val
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}