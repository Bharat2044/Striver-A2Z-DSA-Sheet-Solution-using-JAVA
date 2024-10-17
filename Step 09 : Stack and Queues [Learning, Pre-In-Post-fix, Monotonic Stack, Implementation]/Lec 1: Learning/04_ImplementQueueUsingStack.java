// Question Link: https://leetcode.com/problems/implement-queue-using-stacks/


class MyQueue {
    
    // Time Complexity = O(n), Space Complexity = O(n)
    // Two stacks to simulate queue behavior
    private Stack<Integer> stack1;  // First stack used for pushing elements
    private Stack<Integer> stack2;  // Second stack used for popping/peeking elements
    
    // Constructor to initialize both stacks
    public MyQueue() {
        stack1 = new Stack<>();  // Initialize stack1
        stack2 = new Stack<>();  // Initialize stack2
    }

    // Push element x to the back of the queue
    public void push(int x) {
        stack1.push(x);  // Always push to stack1
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {  
            while (!stack1.isEmpty()) {  // Transfer all elements from stack1 to stack2
                stack2.push(stack1.pop());  // Pop from stack1 and push into stack2, reversing the order
            }
        }
        return stack2.pop();  // Pop from stack2, which now simulates the front of the queue
    }

    // Get the front element without removing it
    public int peek() {
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {  
            while (!stack1.isEmpty()) {  // Transfer all elements from stack1 to stack2
                stack2.push(stack1.pop());  // Pop from stack1 and push into stack2
            }
        }
        return stack2.peek();  // Peek at the top of stack2, which simulates the front of the queue
    }

    // Return true if the queue is empty, otherwise false
    public boolean empty() {
        // The queue is empty only if both stacks are empty
        return stack1.isEmpty() && stack2.isEmpty();  // Check if both stack1 and stack2 are empty
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
