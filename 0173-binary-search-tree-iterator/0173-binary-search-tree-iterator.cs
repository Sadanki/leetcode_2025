public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        PushLeft(root);
    }

    public int Next() {
        var node = stack.Pop();
        int result = node.val;

        // If node has a right child, push all its left children
        if (node.right != null) {
            PushLeft(node.right);
        }

        return result;
    }

    public bool HasNext() {
        return stack.Count > 0;
    }

    private void PushLeft(TreeNode node) {
        while (node != null) {
            stack.Push(node);
            node = node.left;
        }
    }
}