/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        return countPaths(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    private int countPaths(TreeNode node, long sum){
    if(node == null) return 0;

    int count = 0;
    if(node.val == sum) count++;

    count += countPaths(node.left, sum-node.val);
    count += countPaths(node.right, sum-node.val);

    return count;
}
}