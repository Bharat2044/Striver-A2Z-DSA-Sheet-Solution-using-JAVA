// Question Link: https://leetcode.com/problems/search-in-rotated-sorted-array/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    public int search(int[] nums, int target) {
        // Iterate through each element in the array 'nums'
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element matches the target value
            if (nums[i] == target) {
                // If a match is found, return the index of the target
                return i;
            }
        }
        
        // If the target is not found after iterating through the array, return -1
        return -1;
    }
    */


    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int search(int[] nums, int target) {
        // Initialize the pointers for the start and end of the array
        int left = 0, right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;

            // If the target is found at mid, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part of the array is sorted
            if (nums[left] <= nums[mid]) {
                // Left part is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in the left part
                    right = mid - 1;
                } else {
                    // Target is in the right part
                    left = mid + 1;
                }
            } else {
                // Right part is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in the right part
                    left = mid + 1;
                } else {
                    // Target is in the left part
                    right = mid - 1;
                }
            }
        }

        // If the target is not found, return -1
        return -1;
    }
}
