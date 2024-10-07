// Question Link: https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1


class CheckBit {
    // Function to check if Kth bit is set or not.
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(k), Space Complexity = O(1)
    static boolean checkKthBit(int number, int k) {
        
        // Divide the number by 2 k times
        for (int i = 0; i < k; i++) {
            number /= 2;
        }
        
        // Check if the least significant bit is 1
        return (number % 2) == 1;
    }
    */
    
    /*
    // 2nd Approach: Brute Force Solution(Using Recursion) - Time Complexity = O(k), Space Complexity = O(k)
    static boolean checkKthBit(int number, int k) {
        // Base case: if k is 0, check if the least significant bit is 1
        if (k == 0) {
            return (number & 1) == 1;
        }
        // Recursive case: right shift the number and decrement k
        return checkKthBit(number >> 1, k - 1);
    }
    */
    
    /*
    // 3rd Approach: Brute Force Solution - Time Complexity = O(logn), Space Complexity = O(logn)
    static boolean checkKthBit(int number, int k) {
        // Convert the number to binary string
        String binaryString = Integer.toBinaryString(number);
        
        // Check if the k-th bit from the right is 1
        // Adjust for zero-indexing: length - 1 - k
        if (k < binaryString.length()) {
            return binaryString.charAt(binaryString.length() - 1 - k) == '1';
        }
        
        // If k is out of bounds, the bit is 0
        return false;
    }
    */

    /*
    // 4th Approach: Optimal Solution - Time Complexity = O(1), Space Complexity = O(1)
    static boolean checkKthBit(int number, int k) {
        // Create a mask by shifting 1 to the k-th position
        int mask = 1 << k;
        
        // Use bitwise AND to check if the k-th bit is set
        return (number & mask) != 0;
    }
    */

    // 5th Approach: Optimal Solution - Time Complexity = O(1), Space Complexity = O(1)
    static boolean checkKthBit(int number, int k) {
        // Right shift the number k times to bring the kth bit to the least significant position
        int shiftedNumber = number >> k;
        
        // Check if the least significant bit is 1 (if the kth bit is set)
        boolean isKthBitSet = (shiftedNumber & 1) == 1;
        
        // Return the result
        return isKthBitSet;
    }
}
