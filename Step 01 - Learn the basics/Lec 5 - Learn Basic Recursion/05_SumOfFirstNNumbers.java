// Question Link: https://www.geeksforgeeks.org/problems/sum-of-first-n-terms5843/1


class Solution {
    // 1st Approachh: Using Recursion - Time Complexity = O(n), Space Complexity = O(n)
    long sumOfSeries(long n) {
        // Base case: if n is 1, the sum of cubes is simply 1^3 which is 1
        if (n == 1) {
            return 1;
        }
        
        // Recursive case: return the cube of n plus the sum of cubes of numbers from 1 to n-1
        return n * n * n + sumOfSeries(n - 1);
    }
    
    
    /*
    // 2nd Approachh: Using Math - Time Complexity = O(1), Space Complexity = O(1)
    long sumOfSeries(long n) {
        // Calculate the sum of the first n natural numbers
        long sum = (n * (n + 1)) / 2;
        
        // Return the square of the sum
        return sum * sum;
    }
    */
}
