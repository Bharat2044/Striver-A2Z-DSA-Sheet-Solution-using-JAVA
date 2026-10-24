// Question Link: https://www.geeksforgeeks.org/problems/lcm-and-gcd4516/1


class Solution {
    
    /**
     * 1st Approach: Brute Force - Gets TLE
     * 
     * Time Complexity: O(min(a, b))
     *  - The loop iterates from the minimum of A and B down to 1, making it linear with respect to the smaller of the two numbers.
     * Space Complexity: O(1)
     *  - The function uses a constant amount of space regardless of the input size.
    */
    /*
    static Long gcd(Long a, Long b) {
        // Initialize gcd to 1
        Long ans = 1L;
        
        // Iterate from the smaller of a and b down to 1
        for (long i = Math.min(a, b); i >= 1; i--) {
            // Check if i is a divisor of both a and b
            if (a % i == 0 && b % i == 0) {
                // Set gcd to i and exit the loop
                ans = i;
                break;
            }
        }
        
        // Return the calculated gcd
        return ans;
    }
    */
    
    /**
     * 2nd Approach: Using Euclidean’s Algorithm
     * 
     * Time Complexity: O(max(a, b))
     *  - The loop runs until both numbers are equal, which can take up to the maximum of a or b iterations in the worst case.
     * Space Complexity: O(1)
     *  - The function uses a constant amount of space regardless of the input size.
    */
    /*
    static Long gcd(Long a, Long b) {
        // Loop until both numbers are equal
        while (a != b) {
            // If a is greater, subtract b from a
            if (a > b) {
                a = a - b;
            } else {
                // If b is greater, subtract a from b
                b = b - a;
            }
        }
        
        // Return the GCD (when a equals b)
        return a;
    }
    */
    
    /**
     * 3rd Approach: Using Optimized Euclidean’s Algorithm
     * 
     * Time Complexity: O(log(min(a, b)))
     *  - The Euclidean algorithm is efficient and runs in logarithmic time relative to the smaller of the two numbers.
     * Space Complexity: O(1)
     *  - The function uses a constant amount of space regardless of the input size.
    */
    static Long gcd(Long a, Long b) {
        
        // Loop until remainder is zero
        while (b != 0) {
            // Calculate remainder of a divided by b
            long rem = a % b;
            a = b; // Assign b to a
            b = rem; // Assign remainder to b
        }
        
        // Return the GCD (when remainder is zero)
        return a;
    }
    
    // Time Complexity = O(log(min(a, b))), Space Complexity = O(1)
    static Long[] lcmAndGcd(Long A, Long B) {
        // Compute the GCD of A and B
        Long gcd = gcd(A, B);
        
        // Calculate LCM using the formula: LCM = (A * B) / GCD
        long lcm = (A * B) / gcd;
        
        // Return the LCM and GCD as an array
        return new Long[]{lcm, gcd};
    }

};
