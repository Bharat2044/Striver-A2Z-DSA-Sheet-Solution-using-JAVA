// Question Link: https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=postfix-to-prefix-conversion


class Solution {
    
    // Time Complexity = O(n), Space Complexity = O(n)
    static String postToInfix(String exp) {
        
        // Stack to store the infix expressions
        Stack<String> stack = new Stack<>();

        // Traverse each character of the postfix expression
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            
            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + ""); // Convert char to string and push
            }
            // If the character is an operator
            else {
                // Pop two operands from the stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Create the new infix expression with parentheses
                String newExp = "(" + operand1 + ch + operand2 + ")";
                
                // Push the new expression back to the stack
                stack.push(newExp);
            }
        }

        // The final expression left in the stack is the infix expression
        return stack.pop();
    }
}
