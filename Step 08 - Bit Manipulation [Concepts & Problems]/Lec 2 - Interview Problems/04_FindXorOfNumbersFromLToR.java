// Question Link: https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-xor-of-numbers-from-l-to-r


class Solution {
    // Method to compute XOR of numbers from 0 to n
    static int xorTillN(int n) {
        // If n is divisible by 4, the XOR of numbers from 0 to n is n
        if (n % 4 == 0) {
            return n;
        }
        // If the remainder when n is divided by 4 is 1, the XOR of numbers from 0 to n is 1
        else if (n % 4 == 1) {
            return 1;
        }
        // If the remainder when n is divided by 4 is 2, the XOR of numbers from 0 to n is n + 1
        else if (n % 4 == 2) {
            return n + 1;
        }
        // If the remainder when n is divided by 4 is 3, the XOR of numbers from 0 to n is 0
        else {
            return 0;
        }
    }
    
    // Time Complexity = O(1), Space Complexity = O(1)
    public static int findXOR(int l, int r) {
        // Calculate the XOR of numbers from 0 to R using the xorTillN method
        int xorR = xorTillN(r);
        
        // Calculate the XOR of numbers from 0 to L-1 using the xorTillN method
        int xorL = xorTillN(l - 1);
        
        // XOR from L to R is given by the XOR of numbers from 0 to R
        // XORed with the XOR of numbers from 0 to L-1
        return xorR ^ xorL;
    }
}
