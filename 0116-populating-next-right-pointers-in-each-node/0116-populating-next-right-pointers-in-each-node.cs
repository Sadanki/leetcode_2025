/*
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

public class Solution {
    public Node Connect(Node root) {
        if(root == null) return null;

        var queue = new Queue<Node>();
        queue.Enqueue(root);

        while(queue.Count > 0){
            int size = queue.Count;
            Node prev = null;


            for(int i = 0; i< size; i++){
                var node = queue.Dequeue();
                if(prev != null){
                    prev.next = node;
                }

                prev = node;

                if(node.left != null) queue.Enqueue(node.left);
                if(node.right != null) queue.Enqueue(node.right);
            }

            prev.next = null;
        }
        return root;
    }
}