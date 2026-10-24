// Question Link: https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1


class Solution {

    // Time Complexity = O(n), Space Complexity = O(1)
    static int minJumps(int[] arr, int n) {
        // If there's only one element, no jumps are needed
        if (n == 1) {
            return 0;
        } 
        
        // If the first element is 0, it's not possible to move anywhere
        if (arr[0] == 0) {
            return -1;
        }
        
        // Initialize variables
        int jumps = 0; // Number of jumps made
        int currentEnd = 0; // The farthest point reachable with the current number of jumps
        int farthest = 0; // The farthest point reachable with the next jump
        
        for (int i = 0; i < n; i++) {
            // Update the farthest point reachable
            farthest = Math.max(farthest, i + arr[i]);
            
            // If we've reached the end of the array, return the number of jumps
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // If the end of the array is within reach with the current jump
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }
        
        // If the loop ends without reaching the last element
        return -1;
    }
}
