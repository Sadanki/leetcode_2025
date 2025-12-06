class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify handling of head
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10; // Update carry
            current.next = new ListNode(sum % 10); // Create new node
            current = current.next;

            // Move forward in lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry remains, add a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}