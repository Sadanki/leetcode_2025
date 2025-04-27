class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);  // Initialize dummy node
        dummy.next = head;
        
        ListNode prev = dummy;  // Initialize prev to dummy node
        
        while (head != null) {  // Traverse the list
            if (head.val == val) {  // If the value matches, remove the node
                prev.next = head.next;
            } else {
                prev = head;  // Otherwise, move prev forward
            }
            head = head.next;  // Move head forward
        }
        
        return dummy.next;  // Return the modified list
    }
}
