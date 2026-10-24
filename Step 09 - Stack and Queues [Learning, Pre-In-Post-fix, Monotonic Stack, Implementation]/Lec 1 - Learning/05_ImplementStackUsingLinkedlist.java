// Question Link: https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-stack-using-linked-list


class MyStack {
    // Node class representing each element in the stack
    // class StackNode {
    //     int data;
    //     StackNode next;

    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }

    // Pointer to the top of the stack
    StackNode top;

    // Constructor initializing the top to null (empty stack)
    MyStack() {
        top = null;
    }

    // Function to push an integer into the stack.
    void push(int a) {
        // Create a new node with the given data
        StackNode newNode = new StackNode(a);
        
        // Make the new node point to the current top
        newNode.next = top;
        
        // Update the top to point to the new node
        top = newNode;
    }

    // Function to remove an item from the top of the stack.
    int pop() {
        // If the stack is empty, return -1
        if (top == null) {
            return -1;
        }

        // Get the data of the top node
        int poppedData = top.data;
        
        // Move the top to the next node
        top = top.next;
        
        // Return the popped data
        return poppedData;
    }
}
