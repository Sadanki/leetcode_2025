import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    
    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);    // Step 1: Traverse left subtree
        postorder(node.right, result);   // Step 2: Traverse right subtree
        result.add(node.val);            // Step 3: Visit the root
    }
}
