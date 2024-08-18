// Question Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    public boolean search(int[] nums, int target) {

        // Iterate over the entire array to check each element.
        for (int i = 0; i < nums.length; i++) {

            // If the current element is equal to the target value, return true.
            // This indicates that the target is found in the array.
            if (nums[i] == target) {
                return true;
            }
        }

        // If the loop completes without finding the target, return false.
        // This indicates that the target is not present in the array.
        return false;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public boolean search(int[] nums, int target) {
        // Initialize the start and end pointers for binary search
        int start = 0, end = nums.length - 1;

        // Perform binary search
        while (start <= end) {
            // Calculate the middle index
            int mid = start + (end - start) / 2;

            // If the target is found at mid, return true
            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates by moving the start pointer rightward
            // This helps in skipping the duplicates and ensuring proper binary search
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                // Left half is sorted
                if (nums[start] <= target && target < nums[mid]) {
                    // Target is in the left sorted half
                    end = mid - 1;
                } else {
                    // Target is in the right half
                    start = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    // Target is in the right sorted half
                    start = mid + 1;
                } else {
                    // Target is in the left half
                    end = mid - 1;
                }
            }
        }

        // Target is not found, return false
        return false;
    }
}
