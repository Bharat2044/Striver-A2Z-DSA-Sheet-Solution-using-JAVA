// Question Link: https://www.geeksforgeeks.org/problems/reverse-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-stack


class Solution { 

    // Helper function to insert an element at the bottom of the stack
    static void insertAtBottom(Stack<Integer> s, int x) {
        
        // Base case: If the stack is empty, push the element
        if (s.isEmpty()) {
            s.push(x);
            return;
        }

        // Step 1: Remove the top element
        int topElement = s.pop();

        // Step 2: Recursively call insertAtBottom to reach the bottom
        insertAtBottom(s, x);

        // Step 3: Push the top element back on the stack
        s.push(topElement);
    }
    
    // Function to reverse the stack.
    // Time Complexity = O(n^2), Space Complexity = O(n)
    static void reverse(Stack<Integer> s) {
        
        // If the stack is empty, return.
        if (s.isEmpty()) {
            return;
        }

        // Remove the top element and hold it in a variable
        int topElement = s.pop();

        // Reverse the remaining stack
        reverse(s);

        // Insert the popped element at the bottom of the reversed stack
        insertAtBottom(s, topElement);
    }
}
