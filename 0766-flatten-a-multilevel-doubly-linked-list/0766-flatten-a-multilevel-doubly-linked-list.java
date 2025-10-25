class Solution {
    public Node flatten(Node head) {
        flattenDFS(head);
        return head;
    }

    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If there's a child, flatten it
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenDFS(childHead);

                // Connect curr to child
                curr.next = childHead;
                childHead.prev = curr;

                // Connect child tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Clear child pointer
                curr.child = null;
                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}