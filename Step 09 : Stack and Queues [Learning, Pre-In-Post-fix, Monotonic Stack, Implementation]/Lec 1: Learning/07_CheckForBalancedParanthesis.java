// Question Link: https://leetcode.com/problems/valid-parentheses/description/


class Solution {
    /*
    // 1st Approach - Time Complexity = O(n), Space Complexity = O(n)
    public boolean isValid(String s) {
        // Initialize a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Create a mapping of closing brackets to their corresponding opening brackets
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '('); // Map closing parenthesis to opening parenthesis
        mapping.put('}', '{'); // Map closing brace to opening brace
        mapping.put(']', '['); // Map closing bracket to opening bracket

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (mapping.containsValue(c)) {
                stack.push(c);
            }
            // If the character is a closing bracket
            else if (mapping.containsKey(c)) {
                // If the stack is empty (no matching opening bracket)
                // or the top element of the stack doesn't match the corresponding opening bracket, return false
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        // After iterating through the string, return true if the stack is empty (all brackets matched)
        return stack.isEmpty();
    }
    */

    // 2nd Approach - Time Complexity = O(n), Space Complexity = O(n)
    public boolean isValid(String s) {
        // Initialize a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Handle closing brackets
            else {
                // If the stack is empty or the top element doesn't match the closing bracket, return false
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top of the stack and check if it matches the corresponding opening bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets are matched; otherwise, it's invalid
        return stack.isEmpty();
    }
}
