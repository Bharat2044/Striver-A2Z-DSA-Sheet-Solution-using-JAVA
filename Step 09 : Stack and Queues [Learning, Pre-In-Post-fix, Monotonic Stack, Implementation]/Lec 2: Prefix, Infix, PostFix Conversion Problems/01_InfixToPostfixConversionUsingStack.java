// Question Link: https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=infix-to-postfix


class Solution {
    // Function to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3; // Highest precedence
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
    
    // Function to convert infix expression to postfix expression
    // Time Complexity = O(n), Space Complexity = O(n)
    public static String infixToPostfix(String exp) {
        // Stack to store operators
        Stack<Character> stack = new Stack<>();
        
        // StringBuilder to store the postfix expression
        StringBuilder result = new StringBuilder();
        
        // Traverse the infix expression
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            
            // If the character is an operand, add it to the output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If the character is '(', push it onto the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop the '(' from the stack
            }
            // If the character is an operator
            else {
                // Pop from the stack while precedence of the top of the stack is greater than or equal to the current operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // Return the resultant postfix expression as a string
        return result.toString();
    }
}
