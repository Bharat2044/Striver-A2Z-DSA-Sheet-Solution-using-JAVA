// Question Link: https://leetcode.com/problems/remove-k-digits/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(k * n), Space Complexity = O(n)
    public String removeKdigits(String num, int k) {
    
        // If k equals the length of num, we would remove all digits, resulting in "0"
        if (k == num.length()) {
            return "0"
        };
        
        // Initialize the smallest number as the original num
        String smallest = num;

        // Loop k times to remove one digit at a time
        for (int i = 0; i < k; i++) {
            // Update smallest by removing one digit to get the smallest possible result
            smallest = removeOneDigit(smallest);
        }

        // Return the final result after removing leading zeros
        return stripLeadingZeros(smallest);
    }

    // Helper function to remove one digit in a way that results in the smallest number
    private String removeOneDigit(String num) {
        int n = num.length(); // Get the length of the current number

        // Traverse the number and find the first pair where num[i] > num[i + 1]
        for (int i = 0; i < n - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                // Remove the digit at index i by slicing around it to create a smaller number
                return num.substring(0, i) + num.substring(i + 1);
            }
        }

        // If all digits are in increasing order, remove the last digit to reduce the number
        return num.substring(0, n - 1);
    }

    // Helper function to remove leading zeros from the resulting number
    private String stripLeadingZeros(String num) {
        int i = 0; // Initialize index to track leading zeros
        
        // Increment index to skip all leading zeros in num
        while (i < num.length() && num.charAt(i) == '0') i++;

        // Create the result by slicing from the first non-zero index
        String result = num.substring(i);

        // If the result is empty (all zeros were removed), return "0"
        return result.isEmpty() ? "0" : result;
    }
    */

    /*
    // 2nd Approach: Optimal Solution - Time Complexity = O(k * n), Space Complexity = O(n)
    public String removeKdigits(String num, int k) {
        // If k equals the length of num, all digits will be removed, so return "0"
        if (k == num.length()) {
            return "0";
        }
        
        // Initialize a Deque to use as a stack for storing digits
        Deque<Character> stack = new ArrayDeque<>();
        
        // Iterate through each digit in num
        for (char digit : num.toCharArray()) {
            // While the stack is not empty, k is greater than 0, and the top of the stack is greater than the current digit:
            // Pop the stack to remove the larger digit, making the number smaller
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop(); // Remove the top digit from the stack
                k--; // Decrease k as we have removed one digit
            }
            // Push the current digit onto the stack
            stack.push(digit);
        }

        // If k is still greater than 0 after the loop, remove the last k digits from the stack
        while (k > 0) {
            stack.pop(); // Pop the top element
            k--; // Decrease k as one digit has been removed
        }

        // Initialize a StringBuilder to store the result in reverse order
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast()); // Append each digit from the stack in reverse order
        }

        // Remove any leading zeros from the result
        int index = 0; // Initialize index to track leading zeros
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }

        // Slice result from the first non-zero index
        result = new StringBuilder(result.substring(index));

        // If the result is empty after removing zeros, return "0", otherwise return the result as a string
        return result.length() == 0 ? "0" : result.toString();
    }
    */

    // 3rd Approach: Optimal Solution - Time Complexity = O(k * n), Space Complexity = O(n)
    public String removeKdigits(String num, int k) {
        
        // If k equals the length of num, we would remove all digits, resulting in "0"
        if (k == num.length()) {
            return "0";
        }

        // Create an array to simulate a stack for storing the digits of the resulting smallest number
        char[] stack = new char[num.length()];
        int top = 0; // Pointer to track the top of the stack

        // Iterate through each digit in num
        for (char digit : num.toCharArray()) {
            // While the stack is not empty, k > 0, and the top of the stack is greater than the current digit:
            // Decrement top to "pop" the last digit and reduce k
            while (top > 0 && k > 0 && stack[top - 1] > digit) {
                top--; // Move the top pointer down to remove the last added element
                k--;   // Decrease k as we have removed one digit
            }
            // Place the current digit at the top of the "stack" array and increment top
            stack[top++] = digit;
        }

        // Adjust top by subtracting any remaining k, in case there are still digits to remove
        top -= k;

        // Identify the starting index, skipping leading zeros
        int start = 0;
        while (start < top && stack[start] == '0') start++;

        // Return "0" if the result is empty after removing leading zeros, otherwise return the result substring
        return start == top ? "0" : new String(stack, start, top - start);
    }
}
