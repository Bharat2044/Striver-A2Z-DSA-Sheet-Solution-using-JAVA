// Question Link: https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prefix-to-infix-conversion


class Solution {
    
    // Function to convert prefix expression to infix expression
    // Time Complexity = O(n), Space Complexity = O(n)
    static String preToInfix(String pre_exp) {
        // Stack to hold strings (sub-expressions)
        Stack<String> stack = new Stack<>();
        
        // Traverse the prefix expression from right to left
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);
            
            // If the character is an operand (alphabet), push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            }
            // If the character is an operator, pop two operands from the stack
            else {
                // Pop two operands
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                
                // Form the infix expression and push it back to the stack
                String expression = "(" + operand1 + ch + operand2 + ")";
                stack.push(expression);
            }
        }
        
        // The final element in the stack will be the full infix expression
        return stack.peek();
    }
}
