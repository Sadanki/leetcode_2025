class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);  // Create a dummy node to simplify the merging process
        ListNode current = dummy;  // This will be used to build the merged list
        
        // Traverse both lists and merge them in sorted order
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;  // Link the smaller node to the merged list
                list1 = list1.next;  // Move to the next node in list1
            } else {
                current.next = list2;  // Link the smaller node to the merged list
                list2 = list2.next;  // Move to the next node in list2
            }
            current = current.next;  // Move current to the next node in the merged list
        }

        // If any elements remain in list1 or list2, attach them to the merged list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;  // Return the merged list (skipping the dummy node)
    }
}
