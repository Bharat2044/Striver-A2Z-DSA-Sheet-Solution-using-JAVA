// Question Link: https://leetcode.com/problems/string-to-integer-atoi/description/


class Solution {

    // Recursive helper function
    private int myAtoiHelper(String s, int index, int sign, long result) {
        // Base case: if the index is out of bounds, return the current result
        if (index == s.length()) {
            return (int) result * sign;
        }
        
        char c = s.charAt(index);
        
        // Handle the sign (only on the first character)
        if (index == 0 && (c == '-' || c == '+')) {
            sign = (c == '-') ? -1 : 1;
            return myAtoiHelper(s, index + 1, sign, result);
        }
        
        // If the current character is a digit, process it
        if (Character.isDigit(c)) {
            result = result * 10 + (c - '0');
            
            // Handle overflow and return bounds
            if (result * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            if (result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            
            return myAtoiHelper(s, index + 1, sign, result);
        }
        
        // If a non-digit character is encountered, return the current result
        return (int) result * sign;
    }

    // 1st Approoach: Using Recursion - Time Complexity = O(n), Space Complexity = O(n)
    public int myAtoi(String s) {

        return myAtoiHelper(s.trim(), 0, 1, 0);
    }

    /*
    // 2nd Approoach - Time Complexity = O(n), Space Complexity = O(1)
    public int myAtoi(String s) {
        long ans = 0;  // Initialize variable to store result.
        int sign = 1;  // Initialize sign to positive.
        int i = 0;     // Index to traverse the string.

        // Skip leading whitespaces.
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign ('-' or '+') and update the sign accordingly.
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Convert numeric characters to integer.
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i) - '0');  // Build the number.

            // Check for overflow beyond 32-bit integer limits.
            if (ans * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;  // Return minimum bound on overflow.
            }

            if (ans * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;  // Return maximum bound on overflow.
            }

            i++;  // Move to the next character.
        }

        // Return the final result with appropriate sign.
        return (int) ans * sign;  
    }
    */
}
