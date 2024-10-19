// Question Link: https://leetcode.com/problems/min-stack/description/


/*
class Pair {
    int x, y; // 'x' represents the value being pushed, and 'y' represents the minimum value at that point in the stack

    // Constructor to initialize the pair of value and minimum
    Pair(int x, int y) {
        this.x = x; // Store the value
        this.y = y; // Store the current minimum value
    }
}

// 1st Approach - Time Complexity = O(1), Space Complexity = O(n)
class MinStack {
    // Stack that holds pairs, where each pair contains the value and the minimum at that point
    Stack<Pair> st;

    // Constructor to initialize the stack
    public MinStack() {
        st = new Stack<>();
    }

    // Push a new value onto the stack
    public void push(int x) {
        int min;
        // If the stack is empty, the minimum is the value itself
        if (st.isEmpty()) {
            min = x;
        } 
        // If the stack is not empty, the minimum is the smaller of the current value and the current minimum
        else {
            min = Math.min(st.peek().y, x);
        }
        // Push the pair (value, minimum) onto the stack
        st.push(new Pair(x, min));
    }

    // Remove the element from the top of the stack
    public void pop() {
        st.pop(); // Simply pop the top element of the stack
    }

    // Return the top element (the value) from the stack
    public int top() {
        return st.peek().x; // Access the 'x' of the top pair which holds the actual value
    }

    // Retrieve the minimum value from the stack
    public int getMin() {
        return st.peek().y; // Access the 'y' of the top pair which holds the minimum value
    }
}
*/


// 2nd Approach - Time Complexity = O(1), Space Complexity = O(n)
class MinStack {
    // Variable to store the current minimum value, initialized to maximum possible integer value
    int min = Integer.MAX_VALUE;
    
    // Stack to store the values and the previous minimum values
    Stack<Integer> stack = new Stack<>();

    // Push a new value onto the stack
    public void push(int x) {
        // If the new value is less than or equal to the current minimum
        if (x <= min) {
            // Push the current minimum onto the stack before updating it
            stack.push(min);
            // Update the minimum to the new value
            min = x;
        }
        
        // Push the actual value onto the stack
        stack.push(x);
    }

    // Remove the element from the top of the stack
    public void pop() {
        // If the value being popped is the current minimum, the next element in the stack is the previous minimum
        if (stack.pop() == min) {
            // Pop the previous minimum and set it as the new minimum
            min = stack.pop();
        }
    }

    // Return the top element from the stack
    public int top() {
        return stack.peek(); // Return the top value of the stack without modifying the stack
    }

    // Retrieve the minimum value in the stack
    public int getMin() {
        return min; // Return the current minimum
    }
}
