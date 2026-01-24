public class Solution {
    public IList<string> BinaryTreePaths(TreeNode root) {
        var result = new List<string>();
        if (root == null) return result;

        void Dfs(TreeNode node, string path) {
            if (node == null) return;

            string currentPath = string.IsNullOrEmpty(path) ? 
                                 node.val.ToString() : 
                                 path + "->" + node.val;

            if (node.left == null && node.right == null) {
                result.Add(currentPath);
                return;
            }

            Dfs(node.left, currentPath);
            Dfs(node.right, currentPath);
        }

        Dfs(root, "");
        return result;
    }
}