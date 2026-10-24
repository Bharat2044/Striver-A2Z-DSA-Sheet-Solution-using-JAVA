// Question Link: https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=infix-to-postfix


class Solution {
    // Function to return precedence of operators.
    static int precedence(char ch) {
        switch (ch) {
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return -1;
        }
    }

    // Function to convert an infix expression to a postfix expression.
    // Time Complexity = O(n), Space Complexity = O(n)
    public static String infixToPostfix(String exp) {
        // Stack to hold operators
        Stack<Character> stack = new Stack<>();
        
        // StringBuilder to build the postfix expression
        StringBuilder result = new StringBuilder();

        // Traverse through the expression
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If the character is an operand, add it to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop from stack until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop the '(' from stack
            }
            // If the character is an operator
            else {
                // Pop operators from the stack to result based on precedence
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                // Push the current operator to stack
                stack.push(ch);
            }
        }

        // Pop all the remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Return the resulting postfix expression
        return result.toString();
    }
}
