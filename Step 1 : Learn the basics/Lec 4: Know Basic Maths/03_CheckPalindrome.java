// Question Link: https://leetcode.com/problems/palindrome-number/description/


class Solution {
    
    // Method to reverse an integer
    public int reverse(int x) {
        // Initialize variable to store the reversed number
        int rev = 0;

        // Loop until the original number becomes zero
        while (x != 0) {
            // Extract the last digit of the number
            int rem = x % 10;

            // Check for potential overflow before multiplying
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0; // Return 0 if overflow would occur
            }

            // Multiply the current reversed number by 10 and add the remainder
            rev = rev * 10 + rem;

            // Remove the last digit from the original number
            x /= 10;
        }

        // Return the reversed number
        return rev;
    }

    // Time Complexity = O(log10(n)), Space Complexity = O(1)
    public boolean isPalindrome(int x) {

        // If numbers are negative, then return 0, because Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }
        
        // Reverse the number
        int rev = reverse(x);

        // Return true if the original number equals the reversed number
        return (x == rev);
    }
}
