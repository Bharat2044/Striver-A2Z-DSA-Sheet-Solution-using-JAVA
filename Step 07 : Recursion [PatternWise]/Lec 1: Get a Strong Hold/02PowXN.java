// Question Link: https://leetcode.com/problems/powx-n/description/


class Solution {
    /*
    // 1st Approach: Brute Force - Time Complexity = O(n), Space Complexity = O(1)
    public double myPow(double x, int n) {
        // If n is negative, we convert x to its reciprocal (1/x) and negate n to make it positive.
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1.0;

        // Multiply x with itself n times to compute x^n.
        for(int i = 1; i <= n; i++) {
            result *= x;
        }

        // Return the final result.
        return result;
    }
    */


    // 2nd Approach: Using Recursion: Divide & Conquer - Time Complexity = O(logn), Space Complexity = O(logn)
    public double myPow(double x, int n) {
        // Base case: Any number raised to the power of 0 is 1.
        if(n == 0) {
            return 1;
        }

        // If n is negative, convert x to its reciprocal (1/x) and negate n.
        if(n < 0) {
            x = 1.0 / x;
            n = -n;
        }

        // Recursively calculate x^(n/2) using divide and conquer.
        double temp = myPow(x, n/2);
        temp = temp * temp;  // Square the result for x^(n/2) * x^(n/2).

        // If n is even, the result is temp. If n is odd, multiply by x one more time.
        if(n % 2 == 0)
            return temp;
        else
            return temp * x;    
    }

    /*
    // 3rd Approach: Using Predefined Function: Time Complexity = O(logn), Space Complexity = O(1)
    public double myPow(double x, int n) {
        // Directly use the Math.pow() function for calculating x^n.
        return Math.pow(x, n);
    }
    */
}
