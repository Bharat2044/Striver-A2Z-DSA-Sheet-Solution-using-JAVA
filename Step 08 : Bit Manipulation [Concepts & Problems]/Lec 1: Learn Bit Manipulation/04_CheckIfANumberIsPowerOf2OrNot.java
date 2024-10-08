// Question Link: https://leetcode.com/problems/power-of-two/


class Solution {

    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(logn), Space Complexity = O(1)
    public boolean isPowerOfTwo(int n) {
        // Start with i as 1 (first power of 2)
        int  i = 1;  

        // Continue multiplying i by 2 until it exceeds n
        while(i <= n) { 
            i <<= 1;  // Left shift i by 1, equivalent to multiplying by 2
        }

        // Check if the final value of i equals n, meaning n is a power of 2
        return (n == i);  
    }
    */

    /*
    // 2nd Approach: Brute Force Solution (Using Recursion) - Time Complexity = O(logn), Space Complexity = O(logn)
    public boolean isPowerOfTwo(int n) {
        // If n is less than or equal to 0, it's not a power of 2
        if(n <= 0) {
            return false;
            }
        
        // Base case: if n is 1, return true; otherwise, check if n is even and recursively call for n/2
        return (n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2)));  // Recursive call reducing n by dividing by 2
    }
    */

    /*
    // 3rd Approach: Better Solution(Using For Loop) - Time Complexity = O(1), Space Complexity = O(1)
    public boolean isPowerOfTwo(int n) {
        // If n is less than or equal to 0, it's not a power of 2
        if(n <= 0) {
            return false;
        }
        
        // Start with 1, the first power of 2
        int ans = 1;  
        
        // Iterate up to 30 because 2^30 is within the 32-bit integer range
        for(int i = 0; i <= 30; i++) {

            // If ans matches n, return true  
            if(ans == n) {
                return true;
            }
            
            // Ensure we don't overflow by multiplying by 2
            if(ans < Integer.MAX_VALUE / 2) {
                ans <<= 1;  // Multiply ans by 2 using left shift
            }
        }
        
        // If no match was found, return false
        return false;  
    }
    */
    
    /*
    // 4th Approach: Optimal Solution(Using Predefined Function) - Time Complexity = O(1), Space Complexity = O(1)
    public boolean isPowerOfTwo(int n) {
        // If n is less than or equal to 0, it's not a power of 2
        if(n <= 0)  {
            return false;
        }
        
        // Uncomment the below line to use the built-in bit count function to check if n has exactly 1 bit set
        return Integer.bitCount(n) == 1;  // bitCount() counts the number of 1s in the binary representation of n
    }
    */

    // 5th Approach: Optimal Solution(Using Bitwise AND Operator) - Time Complexity = O(1), Space Complexity = O(1)
    public boolean isPowerOfTwo(int n) {
        // If n is less than or equal to 0, it's not a power of 2
        if(n <= 0) {
            return false;
        }

        // Use the property that for powers of 2, n & (n - 1) results in 0, meaning n is a power of 2
        return ((n & (n - 1)) == 0);  // Bitwise AND operation
    }
}
