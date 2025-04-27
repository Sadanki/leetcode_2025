import java.util.Stack;

class MyQueue {

    // Declare two stacks at the class level (outside any methods)
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize both stacks
    public MyQueue() {
        stack1 = new Stack<>();  // stack1 for pushing elements (back of the queue)
        stack2 = new Stack<>();  // stack2 for popping elements (front of the queue)
    }

    // Push element to the back of the queue
    public void push(int x) {
        stack1.push(x);  // Simply push to stack1
    }
    
    // Pop the front element from the queue
    public int pop() {
        if (stack2.isEmpty()) {  // If stack2 is empty, transfer elements from stack1
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());  // Transfer all elements to stack2
            }
        }
        return stack2.pop();  // Pop from stack2, which gives the front of the queue
    }
    
    // Get the front element of the queue
    public int peek() {
        if (stack2.isEmpty()) {  // If stack2 is empty, transfer elements from stack1
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());  // Transfer elements to stack2
            }
        }
        return stack2.peek();  // Return the top element of stack2 without removing it
    }
    
    // Check if the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();  // Queue is empty if both stacks are empty
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
