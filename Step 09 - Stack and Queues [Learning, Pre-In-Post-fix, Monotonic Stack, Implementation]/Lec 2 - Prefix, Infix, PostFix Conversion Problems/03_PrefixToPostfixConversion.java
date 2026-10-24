// Question Link: https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prefix-to-postfix-conversion


class Solution {
    
    // Time Complexity = O(n), Space Complexity = O(n)
    static String preToPost(String pre_exp) {
        
        // Create an empty stack
        Stack<String> stack = new Stack<>();
        
        // Traverse the prefix expression from right to left
        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);
            
            // If the character is an operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                // Pop two operands from stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                
                // Form a new postfix expression (operand1 operand2 operator)
                String newExp = operand1 + operand2 + ch;
                
                // Push the new postfix expression back onto the stack
                stack.push(newExp);
            } else {
                // If it's an operand, simply push it to the stack
                stack.push(ch + "");
            }
        }
        
        // The last remaining element in the stack will be the postfix expression
        return stack.pop();
    }
}
