// Question Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    public int[] searchRange(int[] nums, int target) {

        // Initialize variables to store the first and last occurrence of the target.
        int firstOcc = -1, lastOcc = -1;

        // Iterate through the array to find occurrences of the target.
        for (int i = 0; i < nums.length; i++) {
            
            // If the current element matches the target.
            if (nums[i] == target) {
                
                // If this is the first occurrence, update both firstOcc and lastOcc.
                if (firstOcc == -1) {
                    firstOcc = i;
                    lastOcc = i;
                } 
                // If the target has already been found, update lastOcc.
                else {
                    lastOcc = i;
                }
            }
        }

        // Return an array with the first and last occurrence of the target.
        // If the target was not found, both will be -1.
        return new int[]{firstOcc, lastOcc};
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int[] searchRange(int[] nums, int target) {
    
        // Find the first occurrence of the target.
        int firstOcc = findBound(nums, target, true);

        // Find the last occurrence of the target.
        int lastOcc = findBound(nums, target, false);

        // Return the first and last occurrence as the result.
        return new int[]{firstOcc, lastOcc};
    }

    // Helper method to find the boundary (first or last occurrence) of the target.
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                // When target is found, update the boundary and adjust search space.
                bound = mid;
                if (isFirst) {
                    right = mid - 1;  // Search in the left half for the first occurrence.
                } else {
                    left = mid + 1;  // Search in the right half for the last occurrence.
                }
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search in the right half.
            } else {
                right = mid - 1;  // Search in the left half.
            }
        }

        return bound;
    }

}
