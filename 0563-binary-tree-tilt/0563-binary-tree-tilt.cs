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
    private int totalTilt = 0;
    public int FindTilt(TreeNode root) {
        Sum(root);
        return totalTilt;
    }

    private int Sum(TreeNode node){
        if(node == null) return 0;

        int leftSum = Sum(node.left);
        int rightSum = Sum(node.right);

        int tilt  = Math.Abs(leftSum - rightSum);
        totalTilt += tilt;

        return node.val + leftSum + rightSum; 
    }
}