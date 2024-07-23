// Question Link: https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1


class Solution{
    /*
    // 1st Approach: Brute Force - Time Complexity = O(N^2), Space Complexity = O(1)
    static long sumOfDivisors(int N) {
        // Initialize the variable to store the total sum of all divisors
        long sum = 0;
        
        // Loop through each integer from 1 to N
        for (int i = 1; i <= N; i++) {
        
            // Loop through each number from 1 to i to find divisors of i
            for (int j = 1; j <= i; j++) {
            
                // Check if j is a divisor of i
                if (i % j == 0) {
                    // Add j to the total sum if it's a divisor
                    sum += j;
                }
            }
        }
        
        // Return the total sum of all divisors
        return sum;
    }
    */
    
    
    // 2nd Approach: Optimal Approach - Time Complexity = O(N), Space Complexity = O(1)
    static long sumOfDivisors(int N) {
        // Initialize the variable to store the total sum of divisors
        long sum = 0;
        
        // Loop through each integer from 1 to N
        for (int i = 1; i <= N; i++) {
            // Add the product of i and the number of multiples of i up to N
            sum += i * (N / i);
        }
        
        // Return the total sum of all divisors
        return sum;
    }
}
