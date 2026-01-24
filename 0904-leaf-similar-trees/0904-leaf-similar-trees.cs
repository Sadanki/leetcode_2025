public class Solution {
    public bool LeafSimilar(TreeNode root1, TreeNode root2) {
        var leaves1 = new List<int>();
        var leaves2 = new List<int>();

        GetLeaves(root1, leaves1);
        GetLeaves(root2, leaves2);

        if (leaves1.Count != leaves2.Count) return false;

        for (int i = 0; i < leaves1.Count; i++) {
            if (leaves1[i] != leaves2[i]) return false;
        }

        return true;
    }

    private void GetLeaves(TreeNode node, IList<int> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leaves.Add(node.val);
            return;
        }

        GetLeaves(node.left, leaves);
        GetLeaves(node.right, leaves);
    }
}