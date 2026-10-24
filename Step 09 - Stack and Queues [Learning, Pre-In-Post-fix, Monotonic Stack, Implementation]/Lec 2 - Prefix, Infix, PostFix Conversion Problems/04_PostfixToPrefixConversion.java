// Question Link: https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=postfix-to-prefix-conversion


class Solution {
    
    // Time Complexity = O(n), Space Complexity = O(n)
    static String postToPre(String post_exp) {
        
        // Create an empty stack
        Stack<String> stack = new Stack<>();
        
        // Traverse the postfix expression from left to right
        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);
            
            // If the character is an operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // Pop two operands from stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                
                // Form a new prefix expression (operator operand1 operand2)
                String newExp = ch + operand1 + operand2;
                
                // Push the new prefix expression back onto the stack
                stack.push(newExp);
            } else {
                // If it's an operand, simply push it to the stack
                stack.push(ch + "");
            }
        }
        
        // The last remaining element in the stack will be the prefix expression
        return stack.pop();
    }
}
