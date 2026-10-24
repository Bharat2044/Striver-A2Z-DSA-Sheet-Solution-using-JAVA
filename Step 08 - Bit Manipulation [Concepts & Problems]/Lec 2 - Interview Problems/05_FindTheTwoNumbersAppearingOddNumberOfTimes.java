// Question Link: https://www.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1


class Solution {
    
    // Time Complexity = O(n), Space Complexity = O(1)
    public int[] twoOddNum(int Arr[], int N) {
        // XOR of all elements in the array
        int xorResult = 0;
        
        // XOR all the elements, which will give us x ^ y
        for (int num : Arr) {
            xorResult ^= num;
        }
        
        // Find the rightmost set bit in xorResult (x ^ y)
        int rightmostSetBit = xorResult & -xorResult;
        
        // Initialize variables to hold the two odd occurring numbers
        int odd1 = 0, odd2 = 0;
        
        // Divide numbers into two groups based on the rightmost set bit
        for (int num : Arr) {
            if ((num & rightmostSetBit) != 0) {
                // numbers with the rightmost set bit
                odd1 ^= num;
            } else {
                // numbers without the rightmost set bit
                odd2 ^= num;
            }
        }
        
        // Return the two numbers in decreasing order
        if (odd1 > odd2) {
            return new int[]{odd1, odd2};
        } else {
            return new int[]{odd2, odd1};
        }
    }
}
