// Question Link: https://leetcode.com/problems/binary-search/description/


class Solution {
    /*
    // 1st Approach: Iterative Approach - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int search(int[] nums, int target) {
        // Initialize two pointers for binary search.
        // 'left' starts at the beginning of the array, and 'right' starts at the end.
        int left = 0, right = nums.length - 1;

        // Continue searching while the search space is valid (left index is less than or equal to the right index).
        while (left <= right) {
            // Calculate the middle index of the current search space to divide the array.
            // Using (right - left) / 2 prevents potential overflow that could occur with (left + right) / 2.
            int mid = left + (right - left) / 2;

            // If the element at the middle index is the target, return the index.
            if (nums[mid] == target) {
                return mid;
            } 
            // If the target is smaller than the middle element, narrow the search space to the left half.
            else if (nums[mid] > target) {
                right = mid - 1;
            } 
            // If the target is larger than the middle element, narrow the search space to the right half.
            else {
                left = mid + 1;
            }
        }

        // If the loop ends, the target was not found. Return -1 to indicate the target is not in the array.
        return -1;
    }
    */


    // 2nd Approach: Recursive Approach - Time Complexity = O(log(n)), Space Complexity = O(log(n))
    public int search(int[] nums, int target) {
        // Initialize the left and right pointers to cover the entire array
        int left = 0, right = nums.length - 1;

        // Call the recursive binary search function
        int result = binarySearch(nums, left, right, target);

        // Return the result, which will either be the index of the target or -1 if not found
        return result;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        // Base case: if the left pointer exceeds the right pointer, the target is not in the array
        if (left > right) {
            return -1;
        }

        // Calculate the middle index to split the array
        int mid = left + (right - left) / 2;

        // If the middle element is the target, return its index
        if (nums[mid] == target) {
            return mid;
        }
        // If the target is greater than the middle element, search the right half of the array
        else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        }
        // If the target is less than the middle element, search the left half of the array
        else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }
}
