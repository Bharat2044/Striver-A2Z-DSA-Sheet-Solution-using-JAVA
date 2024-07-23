// Question Link: https://www.geeksforgeeks.org/problems/sum-of-all-divisors-from-1-to-n4738/1


class Solution{
    
    // Time Complexity = O(N), Space Complexity = O(1)
    static long sumOfDivisors(int N){
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




/*
The function sumOfDivisors calculates the sum of all divisors of every integer from 1 to N.

Time Complexity: O(N)
- The loop runs from 1 to N, making it linear with respect to the value of N.

Space Complexity: O(1)
- The function uses a constant amount of space regardless of the input size.

Explanation:
- For each integer i from 1 to N, the expression `i * (N / i)` represents the contribution of i to the sum of divisors of all integers up to N.
- The term `(N / i)` calculates how many times i is a divisor for integers from 1 to N.
- Summing up these contributions for all i from 1 to N gives the total sum of divisors for all numbers from 1 to N.
*/
