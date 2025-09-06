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



            //Algorithm/Technique Name: Prefix Sum + HashMap
// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         Map<Long, Integer> prefixSumCount = new HashMap<>();
//         prefixSumCount.put(0L, 1);  // base case
//         return dfs(root, 0, targetSum, prefixSumCount);
//     }

//     private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumCount) {
//         if (node == null) return 0;

//         currSum += node.val;

//         // count paths ending at current node
//         int paths = prefixSumCount.getOrDefault(currSum - targetSum, 0);

//         // add current sum to map
//         prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

//         // explore children
//         paths += dfs(node.left, currSum, targetSum, prefixSumCount);
//         paths += dfs(node.right, currSum, targetSum, prefixSumCount);

//         // backtrack: remove current sum
//         prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

//         return paths;
//     }
// }
