import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>(); // Full binary trees only exist for odd n
        if (memo.containsKey(n)) return memo.get(n);

        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            result.add(new TreeNode(0)); // Base case: single node tree
        } else {
            for (int leftCount = 1; leftCount < n; leftCount += 2) {
                int rightCount = n - 1 - leftCount;
                List<TreeNode> leftTrees = allPossibleFBT(leftCount);
                List<TreeNode> rightTrees = allPossibleFBT(rightCount);

                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}