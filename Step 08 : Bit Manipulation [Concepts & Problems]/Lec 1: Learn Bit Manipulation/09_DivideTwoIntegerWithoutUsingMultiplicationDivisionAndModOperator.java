// Question Link: https://leetcode.com/problems/divide-two-integers/


class Solution {
   
    // Time Complexity = O(log(n)), Space Complexity = O(1)
    public int divide(int dividend, int divisor) {
        // If dividend is Integer.MIN_VALUE and divisor is -1, return Integer.MAX_VALUE to prevent overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; 
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use absolute values to avoid negative issues
        long absDividend = Math.abs((long) dividend); // Cast to long to avoid overflow
        long absDivisor = Math.abs((long) divisor);

        // Initialize the quotient
        int quotient = 0;

        // Perform the division using bit shifting
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            
          // Double the divisor until it's larger than the dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1; // Double the divisor
                multiple <<= 1; // Double the multiple
            }
          
            // Subtract the largest shifted divisor from dividend
            absDividend -= tempDivisor;
            quotient += multiple; // Add the corresponding multiple to quotient
        }

        // Apply the sign to the quotient
        return isNegative ? -quotient : quotient;
    }
}
