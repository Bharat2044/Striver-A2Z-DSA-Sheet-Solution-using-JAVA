// Question Link: https://leetcode.com/problems/count-primes/description/


class Solution {
    // Time Complexity = O(n * log(log(n))), Space Complexity = O(n)
    public int countPrimes(int n) {
        // If n is less than or equal to 2, there are no primes, so return 0
        if (n <= 2) {
            return 0;
        }
        
        // Create a boolean array to mark prime numbers, default all values to true
        boolean[] isprime = new boolean[n];
        
        // Initialize all values in the array to true, assuming all numbers are prime initially
        for (int i = 0; i < n; i++) {
            isprime[i] = true;
        }
        
        // Iterate from 2 to the square root of n (i * i < n)
        // This is the outer loop that handles prime candidates
        for (int i = 2; i * i < n; i++) {
            // If the current number i is still marked as prime
            if (isprime[i]) {
                // Mark multiples of i as non-prime starting from i^2
                for (int j = i * i; j < n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        
        // Initialize count of primes to 0
        int count = 0;
        
        // Count all numbers from 2 to n that are still marked as prime
        for (int i = 2; i < n; i++) {
            if (isprime[i]) {
                count++;
            }
        }
        
        // Return the total count of prime numbers less than n
        return count;
    }
}
