// Question Link: https://www.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(logn), Space Complexity = O(1)
    static int setBit(int n) {
        
        // Variable to keep track of the bit position
        int shift = 0;  
    
        // Iterate through each bit of n
        while ((n >> shift) != 0) {
            
            // Check if the current bit is unset
            if (((n >> shift) & 1) == 0) {
                // Set the bit at position 'shift'
                return n | (1 << shift);
            }
            
            shift++;
        }
    
        // If no unset bit is found, return n | (1 << shift) to set the first zero bit after all 1s
        return n | (1 << shift);
    }
    */

    /*
    // 2nd Approach: Better Solution - Time Complexity = O(1), Space Complexity = O(1)
    static int setBit(int n) {
        // Create bitmask to set the rightmost unset bit
        int bitmask = ~n & (n + 1);
        
        // OR n with the bitmask to set the rightmost unset bit
        return n | bitmask;
    }
    */
    
    // 3rd Approach: Optimal Solution - Time Complexity = O(1), Space Complexity = O(1)
    static int setBit(int n) {
        
        // Adds 1 to n and then performs OR operation with n
        return (n + 1) | n;
    }
}
