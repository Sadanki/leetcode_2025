class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) 
            return false;  // If root is null, subRoot cannot be a subtree
        if (isSameTree(root, subRoot)) 
            return true;  // If the current tree rooted at root matches subRoot
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);  // Check left and right subtrees
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) 
            return true;  // Both trees are null, they are the same
        if (t1 == null || t2 == null) 
            return false;  // One tree is null and the other is not, they are not the same
        return (t1.val == t2.val)  // Check the root values
            && isSameTree(t1.left, t2.left)  // Check if the left subtrees are the same
            && isSameTree(t1.right, t2.right);  // Check if the right subtrees are the same
    }
}
