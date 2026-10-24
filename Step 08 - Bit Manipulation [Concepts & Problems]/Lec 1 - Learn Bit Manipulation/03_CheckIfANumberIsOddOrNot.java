// Question Link: https://www.geeksforgeeks.org/problems/odd-or-even3618/1


class Solution {
    /*
    // 1st Approach - Time Complexity = O(1), Space Complexity = O(1)
    static String oddEven(int number) {
       
        // Check if the number is even
        if (number % 2 == 0) {
            return "even"; // Return "even" if the number is divisible by 2
        } else {
            return "odd";  // Return "odd" if the number is not divisible by 2
        }
    }
    */

    // 2nd Approach - Time Complexity = O(1), Space Complexity = O(1)
    static String oddEven(int number) {
        // Use the bitwise AND operator to check the least significant bit of the number
        // If the least significant bit is 0, the number is even else odd
        if ((number & 1) == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
}
