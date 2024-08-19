// Question Link: https://leetcode.com/problems/valid-palindrome/description/


class Solution {

    // 1st Approach: Using Recursion - Time Complexity = O(n), Space Complexity = O(n)
    public boolean isPalindrome(String s) {
        // Convert string to lowercase for case-insensitive comparison
        s = s.toLowerCase();

        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    // Recursive helper function to check if the substring is a palindrome
    private boolean isPalindromeHelper(String s, int left, int right) {
        // Base case: If pointers cross, the string is a palindrome
        if (left >= right) {
            return true;
        }

        // Skip non-alphanumeric characters from the left
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }

        // Skip non-alphanumeric characters from the right
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }

        // Compare characters at left and right pointers
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        // Recur for the next characters
        return isPalindromeHelper(s, left + 1, right - 1);
    }

    /*
    // 2nd Approach: Using Loops - Time Complexity = O(n), Space Complexity = O(1)
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase to handle case insensitivity
        s = s.toLowerCase();

        int start = 0, end = s.length() - 1;
        
        while (start < end) {
            // Skip non-alphanumeric characters from the start
            if (!((s.charAt(start) >= 'a' && s.charAt(start) <= 'z') || (s.charAt(start) >= '0' && s.charAt(start) <= '9'))) {
                start++;
            }
            // Skip non-alphanumeric characters from the end
            else if (!((s.charAt(end) >= 'a' && s.charAt(end) <= 'z') || (s.charAt(end) >= '0' && s.charAt(end) <= '9'))) {
                end--;
            }
            // Check if characters are not equal
            else if (s.charAt(start) != s.charAt(end)) {
                return false;
            } 
            // Move inward
            else {
                start++;
                end--;
            }
        }

        // If the entire string has been checked and is valid, return true
        return true;
    }
    */

    /*
    // 3rd Approach: Using Loops - Time Complexity = O(n), Space Complexity = O(1)
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer if not pointing to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer if not pointing to an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Check if characters are equal
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move towards the center
            left++;
            right--;
        }

        return true;
    }
    */
}
