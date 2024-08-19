// Question Link: https://leetcode.com/problems/fibonacci-number/


class Solution {

    // Time Complexity = O(2^n), Space Complexity = O(n)
    public int fib(int n) {
        // Base case: if n is 0 or 1, return n (Fibonacci(0) = 0, Fibonacci(1) = 1)
        if (n == 0 || n == 1) {
            return n;
        }

        // Recursive case: return the sum of the (n-1)th and (n-2)th Fibonacci numbers
        return fib(n - 1) + fib(n - 2);
    }
}




/**
 * Time Complexity (TC): O(2^n)
 * - The function makes two recursive calls for each value of n, resulting in an exponential growth in the number of function calls.
 * - This results in a total time complexity of O(2^n) because the same Fibonacci numbers are recalculated multiple times.

 * Space Complexity (SC): O(n)
 * - The space complexity is due to the call stack depth of the recursion.
 * - The maximum depth of the recursion stack is n, so the space complexity is O(n).
 */
