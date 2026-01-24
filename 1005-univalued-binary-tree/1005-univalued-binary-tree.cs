/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsUnivalTree(TreeNode root) {
        if(root == null) return true;
        return Dfs(root, root.val);
    }

    private bool Dfs(TreeNode node, int value){
        if(node == null) return true;

        if(node.val != value) return false;

        return Dfs(node.left, value) && Dfs(node.right, value);
    }
}