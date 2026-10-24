// Question Link: https://leetcode.com/problems/powx-n/description/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(n), Space Complexity = O(1)
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

    /*
    // 2nd Approach: Better Solution(Using Recursion: Divide & Conquer) - Time Complexity = O(log(n)), Space Complexity = O(log(n))
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
        if(n % 2 == 0) {
            return temp;
        } else {
            return temp * x;   
        } 
    }
    */

    // 3rd Approach: Optimal Solution - Time Complexity = O(log(n)), Space Complexity = O(1)
    public double myPow(double x, int n) {
        // If n is 0, return 1 because any number raised to the power of 0 is 1.
        if (n == 0) {
            return 1;
        }

        // Convert n to a long type to handle edge cases like Integer.MIN_VALUE.
        long exp = n;
        
        // If n is negative, invert the base by taking 1/x and change the exponent to positive.
        if (exp < 0) {
            x = 1.0 / x;  // Take the reciprocal of x.
            exp = -exp;   // Make the exponent positive.
        }

        // Initialize the result as 1, since any number to the power of 0 is 1.
        double result = 1.0;

        // Loop until the exponent becomes 0.
        while (exp > 0) {
            // If the exponent is odd, multiply the result by the current base x.
            if (exp % 2 == 1) {
                result *= x;  // Multiply the result by x when the exponent is odd.
            }

            // Square the base for the next iteration since we're halving the exponent.
            x *= x;

            // Divide the exponent by 2 (equivalent to halving the exponent).
            exp /= 2;
        }

        // Return the final result after the loop finishes.
        return result;
    }

    /*
    // 4th Approach: Optimal Solution(Using Predefined Method) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public double myPow(double x, int n) {
        // Directly use the Math.pow() function for calculating x^n.
        return Math.pow(x, n);
    }
    */
}
