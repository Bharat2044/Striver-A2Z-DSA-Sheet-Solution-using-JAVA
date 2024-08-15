// Question Link: https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array


class Solution {

    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    static int findFloor(long arr[], int n, long x) {
        // Initialize the index of the floor value to -1, assuming no valid floor exists.
        int floorIndex = -1;
        
        // Traverse the array to find the floor value.
        for (int i = 0; i < n; i++) {
            
            // If the current element is less than or equal to x, update the floor index.
            if (arr[i] <= x) {
                floorIndex = i;
            }
        }
        
        // Return the index of the floor value, or -1 if no floor exists.
        return floorIndex;
    }
    */
    
    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    static int findFloor(long arr[], int n, long x) {
        // Initialize the index of the floor value to -1, assuming no valid floor exists.
        int floorIndex = -1;
    
        // Initialize the left and right pointers for binary search.
        int left = 0, right = n - 1;
    
        // Perform binary search.
        while (left <= right) {
            // Calculate the middle index.
            int mid = left + (right - left) / 2;
    
            // If the middle element is less than or equal to x, it's a potential floor.
            if (arr[mid] <= x) {
                floorIndex = mid; // Update the floor index.
                left = mid + 1;   // Search the right half for a potentially closer floor.
            } else {
                // If the middle element is greater than x, discard the right half.
                right = mid - 1;
            }
        }
    
        // Return the index of the floor value, or -1 if no floor exists.
        return floorIndex;
    }
}
