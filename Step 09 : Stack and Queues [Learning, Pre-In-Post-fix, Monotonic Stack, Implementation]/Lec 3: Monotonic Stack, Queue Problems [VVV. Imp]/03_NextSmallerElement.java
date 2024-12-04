// Question Link: https://www.interviewbit.com/problems/nearest-smaller-element/



public class Solution {

    // Time Complexity = O(n), Space Complexity = O(n)
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        // Create an ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();
        
        // Stack to store elements for comparison
        Stack<Integer> stack = new Stack<>();
        
        // Traverse through the given array
        for (int i = 0; i < A.size(); i++) {
            int currentElement = A.get(i);

            // Pop elements from the stack that are greater than or equal to currentElement
            while (!stack.isEmpty() && stack.peek() >= currentElement) {
                stack.pop();
            }
            
            // If the stack is not empty, the top element is the nearest smaller element
            if (!stack.isEmpty()) {
                result.add(stack.peek());
            } else {
                // If the stack is empty, no smaller element exists, add -1
                result.add(-1);
            }
            
            // Push the current element to the stack for future comparisons
            stack.push(currentElement);
        }
        
        // Return the result array
        return result;
    }
}
