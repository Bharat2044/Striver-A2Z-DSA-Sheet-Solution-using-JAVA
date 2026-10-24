// Question Link: https://leetcode.com/problems/find-peak-element/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n), Space Complexity = O(1)
    public int findPeakElement(int[] nums) {
    
        // Iterate through the array to find an element that is greater than its neighbors
        for (int i = 0; i < nums.length; i++) {
            
            // Check if the current element is a peak and return its index if it is
            if ((i == 0 || nums[i - 1] < nums[i]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        
        // Fallback return (the function should never reach this point given problem constraints)
        return -1;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int findPeakElement(int[] nums) {
        // Initialize left pointer to the start of the array
        int left = 0;
        
        // Initialize right pointer to the end of the array
        int right = nums.length - 1;
        
        // Perform binary search until left pointer meets the right pointer
        while (left < right) {
            // Calculate the middle index to divide the search range
            int mid = left + (right - left) / 2; 
            
            // Compare the middle element with the next element
            if (nums[mid] > nums[mid + 1]) {
                // If the middle element is greater, the peak is in the left half, including mid
                right = mid; // Adjust the right boundary to mid
            } else {
                // If the middle element is not greater, the peak is in the right half
                left = mid + 1; // Adjust the left boundary to mid + 1
            }
        }
        
        // When left equals right, the peak element is found at this index
        return left;
    }

}
