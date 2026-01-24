public class Solution {
    public IList<int> Preorder(Node root) {
        var result = new List<int>();
        Traverse(root, result);
        return result;
    }

    private void Traverse(Node node, IList<int> result) {
        if (node == null) return;

        // Step 1: Visit the current node
        result.Add(node.val);

        // Step 2: Recursively visit children
        foreach (var child in node.children) {
            Traverse(child, result);
        }
    }
}