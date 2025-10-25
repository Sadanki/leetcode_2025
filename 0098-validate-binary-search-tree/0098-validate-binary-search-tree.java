class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        return node == null ? true :
               (min != null && node.val <= min) || (max != null && node.val >= max) ? false :
               validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}