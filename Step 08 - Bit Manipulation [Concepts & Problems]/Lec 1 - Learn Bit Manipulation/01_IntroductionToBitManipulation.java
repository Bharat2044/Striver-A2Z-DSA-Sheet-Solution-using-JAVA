// Question Link: https://www.geeksforgeeks.org/problems/bit-manipulation-1666686020/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bit-manipulation


class Solution {
    
    // Time Complexity = O(1), Space Complexity = O(1)
    static void bitManipulation(int num, int i) {
        // Get the ith bit
        // Right shift 'num' by 'i-1' positions and use bitwise AND to isolate the ith bit
        int ithBit = (num >> (i - 1)) & 1;  
        
        // Set the ith bit
        // Left shift 1 by 'i-1' positions and use bitwise OR to set the ith bit in 'num'
        int setIthBit = num | (1 << (i - 1));  
        
        // Clear the ith bit
        // Left shift 1 by 'i-1' positions, negate it, and use bitwise AND to clear the ith bit in 'num'
        int clearIthBit = num & (~(1 << (i - 1)));  
        
        // Print the ithBit, setIthBit and clearIthBit
        System.out.print(ithBit + " " + setIthBit + " " + clearIthBit);
    }
}
