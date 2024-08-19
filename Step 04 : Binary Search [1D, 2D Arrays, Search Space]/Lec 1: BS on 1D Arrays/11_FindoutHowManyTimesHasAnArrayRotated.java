// Question Link: https://www.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotation


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n), Space Complexity = O(1)
    public int findKRotation(List<Integer> arr) {

        // Iterate through the array from the first element to the second-to-last element
        for (int i = 0; i < arr.size() - 1; i++) {
            
            // Check if the current element is greater than the next element
            if (arr.get(i) > arr.get(i + 1)) {
                // If true, the array has been rotated at this point, Return the rotation count, which is the index + 1
                return i + 1;
            }
        }
    
        // If the loop completes without finding any rotation point, it means the array was not rotated at all
        // Return 0 in this case, indicating no rotation
        return 0; 
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int findKRotation(List<Integer> arr) {
        // Initialize the low and high pointers
        int low = 0, high = arr.size() - 1; 
        
        // Initialize ans to store the minimum value found
        int ans = Integer.MAX_VALUE; 
        
        // Initialize index to store the rotation index
        int index = -1; 
    
        // Binary search loop, continue until the low pointer crosses the high pointer
        while (low <= high) {
            // Calculate the mid index
            int mid = (low + high) / 2; 
    
            // Check if the subarray between low and high is already sorted
            if (arr.get(low) <= arr.get(high)) {
                // If sorted, check if the element at low is the minimum so far
                if (arr.get(low) < ans) {
                    index = low; // Update the rotation index
                    ans = arr.get(low); // Update the minimum value found
                }
                
                break; // Break the loop as the minimum element is found
            }
    
            // Check if the left part of the array (from low to mid) is sorted
            if (arr.get(low) <= arr.get(mid)) {
                // If sorted, check if the element at low is the minimum so far
                if (arr.get(low) < ans) {
                    index = low; // Update the rotation index
                    ans = arr.get(low); // Update the minimum value found
                }
                
                // Move the low pointer to mid + 1, discarding the left part
                low = mid + 1;
            } else {
                // If the right part of the array (from mid to high) is sorted
                // Check if the element at mid is the minimum so far
                if (arr.get(mid) < ans) {
                    index = mid; // Update the rotation index
                    ans = arr.get(mid); // Update the minimum value found
                }
                
                // Move the high pointer to mid - 1, discarding the right part
                high = mid - 1;
            }
        }
    
        // Return the index of the smallest element, which represents the rotation count
        return index;
    }
}
