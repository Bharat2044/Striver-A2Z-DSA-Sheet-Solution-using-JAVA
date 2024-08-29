// Question Link: https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    long floorSqrt(long n) {
        // Initialize the result variable to store the floor value of the square root
        long result = 0; 
        
        // Iterate from 1 to n to find the largest integer i such that i^2 <= n
        for (long i = 1; i <= n; i++) { 
            
            // Check if the square of i is less than or equal to n
            if (i * i <= n) { 
                result = i; // Update result to the current value of i
            } else {
                break; // Exit the loop if i^2 exceeds n as further squares will be larger
            }
        }
        
        // Return the largest integer whose square is less than or equal to n
        return result; 
    }
    */

    /*
    // 2nd Approach: Better Approach - Time Complexity = O(root(n)), Space Complexity = O(1)
    long floorSqrt(long n) {
        
        // Initialize the result variable to store the floor value of the square root
        long result = 0;
    
        // Iterate from 1 upwards, finding the largest integer i such that i^2 <= n and Stop when i^2 exceeds n
        for (long i = 1; i * i <= n; i++) {
            result = i; // Update result to the current value of i
        }
    
        // Return the largest integer whose square is less than or equal to n
        return result;
    }
    */

    /*
    // 3rd Approach: Optimal Approach (Using Predefined sqrt Method) - Time Complexity = O(log(n)), Space Complexity = O(1)
    long floorSqrt(long n) {

        return (long)Math.sqrt(n);
    }
    */
    
    
    // 4th Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    long floorSqrt(long n) {
        // Initialize start, end, and result variables
        long st = 0, end = n, ans = 0;
    
        // Perform binary search to find the floor of the square root
        while(st <= end) { 
            // Calculate the middle element to avoid overflow
            long mid = st + (end - st) / 2;  
            
            // Calculate the square of the middle element
            long square = mid * mid; 
            
            // If square of mid is equal to n, return mid as the square root
            if(square == n) { 
                return mid;
            } 
            // If square of mid is greater than n, reduce the search space
            else if (square > n) { 
                end = mid - 1; 
            } 
            // If square of mid is less than n, update ans and move to the right half
            else { 
                ans = mid; 
                st = mid + 1; 
            }
        }
        
        // Return the largest integer whose square is less than or equal to n
        return ans;
    }
}
