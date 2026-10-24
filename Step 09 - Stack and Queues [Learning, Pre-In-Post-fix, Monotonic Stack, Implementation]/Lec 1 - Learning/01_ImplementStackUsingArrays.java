// Question Link: https://www.geeksforgeeks.org/problems/implement-stack-using-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-stack-using-array


class MyStack {
    
    private int[] arr; // Array to store elements of the stack
    private int top;   // Index of the top element in the stack

    // Constructor to initialize stack
    public MyStack() {
        arr = new int[1000]; // Stack size is fixed at 1000 elements
        top = -1;            // Stack is empty initially, so top is set to -1
    }

    // Pushes an element onto the stack
    public void push(int x) {
        // Check if the stack is not full (top should be less than the array size)
        if(top < arr.length) {
            top++;          // Increment the top pointer to the next position
            arr[top] = x;   // Place the new element at the top of the stack
        }
    }

    // Pops the top element from the stack
    public int pop() {
        // Check if the stack is not empty (top should be greater than -1)
        if(top > -1) {
            int temp = arr[top]; // Store the top element
            top--;               // Decrement the top pointer to remove the element
            
            return temp;         // Return the popped element
        }
        
        // Return -1 if the stack is empty
        return -1;  
    }
}
