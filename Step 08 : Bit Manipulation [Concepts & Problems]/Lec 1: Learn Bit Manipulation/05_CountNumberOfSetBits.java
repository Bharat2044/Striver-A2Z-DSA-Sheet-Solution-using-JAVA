// Question Link: https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1


class Solution{
    /*
    private static int countBitsInNumber(int x) {
        // Initialize count for each number
        int count = 0; 
        
        // Loop until the number becomes 0
        while (x > 0) { 
            count += x & 1; // Increment count if the last bit is 1
            x >>= 1; // Right shift the number to check the next bit
        }
        
        // Return the count of set bits for this number
        return count; 
    }
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    // 1st Approach: Brute Force Solution - Time Complexity = O(n * logn), Space Complexity = O(1)
    public static int countSetBits(int n) {
        // Initialize total set bit count to 0
        int totalSetBits = 0; 
        
        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) { 
            
            // Add the number of set bits for each number
            totalSetBits += countBitsInNumber(i); 
        }
        
        // Return total set bit count
        return totalSetBits; 
    }
    */
    
    // 2nd Approach: Optimal Solution - Time Complexity = O(logn), Space Complexity = O(logn)
    public static int countSetBits(int n) {
        // Base case: if n is 1 or 2, return n (because 1 has 1 set bit, 2 has 1 set bit)
        if (n <= 2) {
            return n;
        }
    
        // Find the largest power of 2 less than or equal to n
        int x = (int) (Math.log(n) / Math.log(2)); // log2(n) gives the largest power of 2
        int y = 1 << x; // 2^x (largest power of 2 less than or equal to n)
    
        // y * x / 2 is the number of set bits from 1 to y-1, recursively count set bits for n-y
        return (y * x / 2) + countSetBits(n - y) + (n - y + 1); 
    }
}
