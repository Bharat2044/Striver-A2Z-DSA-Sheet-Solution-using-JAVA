// Question Link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * max(nums[])), Space Complexity = O(1)
    public int smallestDivisor(int[] nums, int threshold) {

        // Initialize a variable to find the maximum value in the array
        int maxi = Integer.MIN_VALUE;

        // Loop through the array to find the maximum value
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        // Find the smallest divisor that results in a sum <= threshold
        for (int d = 1; d <= maxi; d++) {

            // Initialize the sum variable to store the summation result for the current divisor
            int sum = 0;

            // Loop through the array to calculate the sum of the division results
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((double)(nums[i]) / (double)(d));
            }

            // If the sum is less than or equal to the threshold, return the current divisor
            if (sum <= threshold) {
                return d;
            }
        }

        // If no divisor is found, return -1
        return -1;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(n * log(max(nums))), Space Complexity = O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        // Initialize the maximum value to the smallest possible integer
        int maxVal = Integer.MIN_VALUE;  

        // Loop through the array to find the maximum value
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);  // Update maxVal to the maximum number in the array
        }

        // Initialize binary search boundaries
        int left = 1;          // The smallest possible divisor
        int right = maxVal;    // The largest possible divisor
        int result = maxVal;   // Initialize result with the maximum possible value

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Calculate the middle value to check as a potential divisor

            // Calculate the sum of division results with the current mid as the divisor
            int sum = 0;
            for (int num : nums) {
                sum += Math.ceil((double) num / mid);  // Add the division result to the sum, rounded up
            }

            // Check if the calculated sum is within the threshold
            if (sum <= threshold) {
                result = mid;    // Update result to the current mid since it's a valid divisor
                right = mid - 1; // Try to find a smaller valid divisor by moving the right boundary
            } else {
                left = mid + 1;  // If sum exceeds the threshold, increase the divisor by moving the left boundary
            }
        }

        // Return the smallest valid divisor found
        return result;
    }
}
