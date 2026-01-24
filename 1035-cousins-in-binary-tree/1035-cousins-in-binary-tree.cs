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
    public bool IsCousins(TreeNode root, int x, int y) {
        TreeNode parentX = null, parentY =null;
        int depthX = -1, depthY= -1;

        void Dfs(TreeNode node, TreeNode parent, int depth){
            if(node == null) return;

            if(node.val == x){
                parentX = parent;
                depthX= depth;
            }

            if(node.val== y){
                parentY = parent;
                depthY = depth; 
            }

            Dfs(node.left, node, depth + 1);
            Dfs(node.right, node, depth +1);
        }

        Dfs(root, null, 0);
        return depthX == depthY && parentX != parentY;

    }
}