class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head, null);
    }
    
    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) return null;
        
        // Find middle using slow/fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow is the middle node
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);
        
        return root;
    }
}