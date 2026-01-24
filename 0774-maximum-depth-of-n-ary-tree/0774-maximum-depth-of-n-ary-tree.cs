public class Solution {
    public int MaxDepth(Node root) {
        if (root == null) return 0;

        int max = 0;
        foreach (var child in root.children) {
            max = Math.Max(max, MaxDepth(child));
        }

        return max + 1; // +1 for the current node
    }
}
