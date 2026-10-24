// Question Link: https://leetcode.com/problems/search-insert-position/description/



class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n), Space Complexity = O(1)
    public int searchInsert(int[] nums, int target) {

        // Initialize index to -1, representing the potential insertion position.
        int index = -1;

        // Iterate through the array to find where the target should be inserted.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                index = i + 1; // Update index if the current element is less than target.
            }
        }

        // Return 0 if target is smaller than all elements, otherwise return the index.
        return (index == -1) ? 0 : index;
    }
    */

    // 2nd Approach: Optimal Approach - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int searchInsert(int[] nums, int target) {

        // Initialize the left pointer to the start of the array.
        int left = 0;

        // Initialize the right pointer to the end of the array.
        int right = nums.length - 1;

        // Continue searching while the search space is valid (left <= right).
        while (left <= right) {

            // Calculate the middle index to divide the search space.
            int mid = left + (right - left) / 2;

            // If the target is found at mid, return the index.
            if (nums[mid] == target) {
                return mid;
            }
            // If the target is greater than the middle element, search in the right half.
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller than the middle element, search in the left half.
            else {
                right = mid - 1;
            }
        }

        // If the target is not found, left will be the insertion point, so return it.
        return left;
    }
}
