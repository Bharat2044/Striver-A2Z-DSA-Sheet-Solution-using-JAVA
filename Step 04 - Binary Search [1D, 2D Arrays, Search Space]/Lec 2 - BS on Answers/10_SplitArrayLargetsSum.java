// Question Link: https://leetcode.com/problems/split-array-largest-sum/description/


class Solution {

    // Method to count the number of partitions required to ensure each subarray has a sum <= maxSum
    public static int countPartitions(int[] nums, int maxSum) {
        int partitions = 1; // Start with one subarray
        long subarraySum = 0; // Initialize the sum of the current subarray

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Check if adding the current element to the subarray does not exceed maxSum
            if (subarraySum + nums[i] <= maxSum) {
                // Add the current element to the current subarray
                subarraySum += nums[i];
            } else {
                // If it exceeds, start a new subarray
                partitions++; // Increase the partition count
                subarraySum = nums[i]; // Start the new subarray with the current element
            }
        }
        return partitions; // Return the number of partitions created
    }

    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * (sum(nums[]) - max(nums[]) + 1)), Space Complexity = O(1)
    public int splitArray(int[] nums, int k) {
        // Initialize low with the first element (minimum possible maximum sum)
        int low = nums[0]; 
        // Initialize high to accumulate the total sum of the array
        int high = 0; 

        // Find the maximum element in the array (to set as initial low) and calculate the total sum (high)
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]); // Update low to the maximum element in the array
            high += nums[i]; // Calculate the total sum of the array
        }

        // Iterate over all possible maximum sums from low to high
        for (int maxSum = low; maxSum <= high; maxSum++) {

            // If the number of partitions needed with this maxSum equals k, return maxSum
            if (countPartitions(nums, maxSum) == k)
                return maxSum;
        }

        // If no exact match is found, return the minimum possible maximum sum
        return low; 
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(n * log(sum(nums[]) - max(nums[]) + 1)), Space Complexity = O(1)    
    public int splitArray(int[] nums, int k) {

        // Initialize low with the maximum element (minimum possible largest subarray sum)
        int low = nums[0];

        // Initialize high to the total sum of the array (maximum possible largest subarray sum)
        int high = 0;

        // Find the maximum element in the array (to set as initial low) and calculate the total sum (high)
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]); // Update low to the maximum element in the array
            high += nums[i]; // Calculate the total sum of the array
        }

        // Use binary search to find the minimized largest sum
        while (low < high) {
            // Calculate the mid value (potential minimized largest sum)
            int mid = low + (high - low) / 2;

            // Check how many partitions are required if we use mid as the maximum subarray sum
            if (countPartitions(nums, mid) > k) {
                // If more partitions are needed, increase low (we need a larger possible sum)
                low = mid + 1;
            } else {
                // If k or fewer partitions are needed, decrease high (we can try a smaller possible sum)
                high = mid;
            }
        }

        // Return the minimized largest sum after the binary search completes
        return low; 
    }
}
