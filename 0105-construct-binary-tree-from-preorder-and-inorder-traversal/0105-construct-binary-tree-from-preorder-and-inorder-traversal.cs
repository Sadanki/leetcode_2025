public class Solution {
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        // Map each value to its index in inorder for O(1) lookup
        var inorderMap = new Dictionary<int, int>();
        for (int i = 0; i < inorder.Length; i++) {
            inorderMap[inorder[i]] = i;
        }

        int preorderIndex = 0;

        TreeNode ArrayToTree(int left, int right) {
            if (left > right) return null;

            // Root is always the current element in preorder
            int rootVal = preorder[preorderIndex++];
            var root = new TreeNode(rootVal);

            // Build left and right subtrees
            root.left = ArrayToTree(left, inorderMap[rootVal] - 1);
            root.right = ArrayToTree(inorderMap[rootVal] + 1, right);

            return root;
        }

        return ArrayToTree(0, inorder.Length - 1);
    }
}