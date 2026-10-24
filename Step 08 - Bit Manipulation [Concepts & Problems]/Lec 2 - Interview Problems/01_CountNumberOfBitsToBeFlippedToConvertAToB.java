// Question Link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/


class Solution {
    /*
    // 1st Approach: Using Built-in Method - Time Complexity = O(1), Space Complexity = O(1)
    public int minBitFlips(int start, int goal) {
        // XOR the start and goal to identify differing bits
        // Count the number of 1s in the result, which indicates the number of bit flips needed
        return Integer.bitCount(start ^ goal);
    }
    */

    // 2nd Approach: - Time Complexity = O(1), Space Complexity = O(1)
    public int minBitFlips(int start, int goal) {
        // Calculate the XOR of start and goal
        int xorResult = start ^ goal;
        
        // Initialize a counter to count differing bits
        int count = 0;

        // Loop until there are no bits left in xorResult
        while (xorResult != 0) {            
            /*
            // Clear the lowest set bit
            xorResult &= (xorResult - 1);
            count++; // Increment the count for each set bit cleared
            */

            // Increment count if the least significant bit (LSB) is 1
            count += xorResult & 1;
            
            // Right shift xorResult to process the next bit
            xorResult >>>= 1; // Use unsigned right shift
        }
        
        // Return the total number of bits that need to be flipped
        return count;
    }

}
