// Question Link: https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(m * n), Space Complexity = O(1)
    public int NthRoot(int n, int m) {
        
        // Iterate through all integers from 1 to m
        for (int i = 1; i <= m; i++) {
            // Variable to store the power of i
            int power = 1; 
            
            // Calculate i raised to the power of n
            for (int j = 1; j <= n; j++) {
                power *= i;
            }
    
            // If i^n is greater than m, stop further checks
            if (power > m) {
                break;
            }
    
            // If i^n equals m, return i as the nth root
            if (power == m) {
                return i;
            }
        }
    
        // Return -1 if no integer i satisfies i^n == m
        return -1;
    }
    */

    /*
    // Function to compute base^exp using exponentiation by squaring
    public static int func(int base, int exp) {
        int ans = 1; // Result of base^exp
        int b = base; // Base value
    
        // Loop to compute base^exp
        while (exp > 0) {
            // If exp is odd, multiply ans by the current base
            if (exp % 2 == 1) {
                ans *= b;
            }
            
            // Square the base and halve the exponent
            b *= b;
            exp /= 2;
        }
        
        return ans;
    }
    
    // 2nd Approach: Better Approach(Using Linear Search - Time Complexity = O(m * log(n)), Space Complexity = O(1)
    public static int NthRoot(int n, int m) {
        
        // Iterate through all integers from 1 to m
        for (int i = 1; i <= m; i++) {
            // int val = (int)Math.pow(i, n);
            
            // Compute i^n using the func method
            int val = func(i, n);
            
            // If i^n equals m, return i
            if (val == m) {
                return i;
            } 
            // If i^n exceeds m, no need to check further
            else if (val > m) {
                break;
            }
        }
        
        // If no integer i satisfies i^n == m, return -1
        return -1;
    }
    */
    
    // Function to compute mid^n and compare it with m
    public static int computePowerAndCompare(int base, int exponent, int target) {
        // Initialize result to 1 (base^0)
        long result = 1; 
        
        // Compute base^exponent
        for (int i = 1; i <= exponent; i++) {
            // Multiply result by base
            result *= base; 
            
            // If result exceeds target, return 2 indicating result is too large
            if (result > target) {
                return 2;
            }
        }
        
        // If result equals target, return 1 indicating a match
        if (result == target) {
            return 1;
        }
        
        // If result is less than target, return 0 indicating result is too small
        return 0;
    }
    
    // 3rd Approach: Optimal Approach(Using Binary Search - Time Complexity = O(n * log(m)), Space Complexity = O(1)
    public static int NthRoot(int n, int m) {
        // Start of the search range
        int low = 1; 
        
        // End of the search range
        int high = m; 
    
        // Perform binary search
        while (low <= high) {
            // Middle of the current range
            int mid = (low + high) / 2; 
            
            // Compute mid^n and compare with m
            int comparisonResult = computePowerAndCompare(mid, n, m); 
    
            // If mid^n equals m, return mid as the nth root
            if (comparisonResult == 1) {
                return mid;
            }
            // If mid^n is less than m, move the lower bound up
            else if (comparisonResult == 0) {
                low = mid + 1;
            }
            // If mid^n is greater than m, move the upper bound down
            else {
                high = mid - 1;
            }
        }
    
        // If no integer x satisfies x^n == m, return -1
        return -1;
    }
}
