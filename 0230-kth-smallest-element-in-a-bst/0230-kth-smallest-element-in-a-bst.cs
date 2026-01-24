public class Solution {
    private int count = 0;
    private int result = 0;

    public int KthSmallest(TreeNode root, int k) {
        Inorder(root, k);
        return result;
    }

    private void Inorder(TreeNode node, int k) {
        if (node == null) return;

        Inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return; // stop once we find kth element
        }

        Inorder(node.right, k);
    }
}