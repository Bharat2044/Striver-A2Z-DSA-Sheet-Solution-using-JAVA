// Question Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Sorting) - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public int findMin(int[] nums) {
        // Sort the input array to restore it to ascending order
        Arrays.sort(nums);

        // Return the first element of the sorted array, which is the minimum value
        return nums[0];
    }
    */

    /*
    // 2nd Approach: Better Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    public int findMin(int[] nums) {
        // Initialize the minimum value with the maximum possible integer value.
        int mini = Integer.MAX_VALUE;

        // Iterate through the array to find the minimum element.
        for (int i = 0; i < nums.length; i++) {

            // If the current element is smaller than the current minimum, update the minimum value.
            if (nums[i] < mini) {
                mini = nums[i];
            }
        }

        // Return the minimum value found in the array.
        return mini;
    }
    */

    /*
    // 3rd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int findMin(int[] nums) {
        // Initialize the low and high pointers for binary search
        int low = 0, high = nums.length - 1; 

        // Initialize the answer with the maximum possible value
        int ans = Integer.MAX_VALUE; 

        // Perform binary search to find the minimum element
        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2; 

            // If the subarray from low to mid is sorted
            if (nums[low] <= nums[mid]) {
                // Update the answer with the smaller value between current answer and nums[low]
                ans = Math.min(ans, nums[low]);

                low = mid + 1; // Move the low pointer to mid + 1 to search the right half
            } else { // If the subarray from mid to high is sorted
                // Update the answer with the smaller value between current answer and nums[mid]
                ans = Math.min(ans, nums[mid]);

                high = mid - 1; // Move the high pointer to mid - 1 to search the left half
            }
        }

        // Return the minimum value found
        return ans; 
    }
    */

    // 4th Approach: Optimal Approach (Using Binary Search - Further Optimization) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int findMin(int[] nums) {
        // Initialize the low and high pointers for binary search
        int low = 0, high = nums.length - 1;

        // Initialize the answer with the maximum possible value
        int ans = Integer.MAX_VALUE;

        // Perform binary search to find the minimum element
        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2;

            // If the subarray from low to high is sorted
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                
                break; // Minimum element found, exit the loop
            }

            // If the left half is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]); // Update the answer

                low = mid + 1; // Move to the right half
            } else { 
                ans = Math.min(ans, nums[mid]); // Update the answer

                high = mid - 1; // Move to the left half
            }
        }

        // Return the minimum value found
        return ans;
    }
}
