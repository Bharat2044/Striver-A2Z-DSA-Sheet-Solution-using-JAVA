// Question Link: https://www.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack


class GfG {
    
    // Time Complexity = O(n^2), Space Complexity = O(n)
    public Stack<Integer> sort(Stack<Integer> s) {
        // Base case: If the stack is empty, return the stack
        if (s.isEmpty()) {
            return s;
        }
        
        // Pop the top element
        int top = s.pop();
        
        // Recursively sort the remaining stack
        sort(s);
        
        // Insert the popped element back into the sorted stack
        sortedInsert(s, top);
        
        // Return the sorted stack
        return s; 
    }
    
    // Helper function to insert an element into the sorted stack
    private void sortedInsert(Stack<Integer> s, int element) {
        
        // Base case: If the stack is empty or the top of the stack is smaller than the element
        if (s.isEmpty() || s.peek() < element) {
            s.push(element); // Insert the element
            return;
        }
        
        // Pop the top element
        int top = s.pop();
        
        // Recursively call sortedInsert for the remaining stack
        sortedInsert(s, element);
        
        // Push the popped element back onto the stack
        s.push(top);
    }
}
