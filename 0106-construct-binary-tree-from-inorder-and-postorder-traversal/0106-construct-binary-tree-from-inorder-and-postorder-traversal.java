class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // Store inorder value -> index for O(1) lookup
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
        // Base case
        if (inStart > inEnd || postIndex < 0) return null;

        // Root value = current postorder element
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Get inorder index of root
        int inIndex = inorderMap.get(rootVal);

        // IMPORTANT: build right subtree first
        root.right = build(inorder, postorder, inIndex + 1, inEnd);
        root.left = build(inorder, postorder, inStart, inIndex - 1);

        return root;
    }
}
