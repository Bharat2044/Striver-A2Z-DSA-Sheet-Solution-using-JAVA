// Question Link: https://leetcode.com/problems/count-good-numbers/


class Solution {
    
    // Define MOD for modular arithmetic to prevent overflow
    public long MOD = 1_000_000_007; 
    
    // Time Complexity = O(log(n)), Space Complexity = O(log(n))
    public int countGoodNumbers(long n) {
        
        // Calculate odd and even positions in the digit string
        long odd = n / 2; // Number of odd positions
        long even = (n + 1) / 2; // Number of even positions
        
        // Calculate total good digit strings using choices for odd/even positions
        return (int)(pow(5, even) * pow(4, odd) % MOD); // 5 choices for even, 4 for odd
    }
    
    // Method to compute (x^n) % MOD using recursion
    public long pow(long x, long n) {
        
        // Base case: x^0 = 1
        if (n == 0) 
            return 1;
        
        // Recursive calculation for x^(n/2)
        long temp = pow(x, n / 2);
        
        // Return squared result based on whether n is even or odd
        if (n % 2 == 0) {
            return (temp * temp) % MOD; // Even: square the result
        } else {
            return (x * temp * temp) % MOD; // Odd: square and multiply by x
        }
    }
}
