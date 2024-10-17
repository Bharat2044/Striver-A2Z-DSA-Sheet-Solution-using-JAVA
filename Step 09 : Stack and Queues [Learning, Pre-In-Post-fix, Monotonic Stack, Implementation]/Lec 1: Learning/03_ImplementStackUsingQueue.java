// Question Link: https://leetcode.com/problems/implement-stack-using-queues/description/


class MyStack {
    // Time Complexity = O(n), Space Complexity = O(n)
    // Define a private queue to simulate stack behavior
    private Queue<Integer> queue;

    // Constructor to initialize the queue
    public MyStack() {
        queue = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        // Add the new element to the end of the queue
        queue.add(x);

        // Rotate the queue to simulate stack behavior by moving earlier elements to the back
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove()); // Remove the front element and add it to the back
        }
    }

    // Pop (remove and return) the top element of the stack
    public int pop() {
        return queue.remove(); // Remove and return the front element, which simulates the top of the stack
    }

    // Return the top element of the stack without removing it
    public int top() {
        return queue.peek(); // Peek the front element, which simulates the top of the stack
    }

    // Check if the stack is empty
    public boolean empty() {
        return queue.isEmpty(); // Return true if the queue (stack) is empty, otherwise false
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
