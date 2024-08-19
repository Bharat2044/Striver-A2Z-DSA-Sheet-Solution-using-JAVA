// Leetcode Question Link: https://leetcode.com/problems/maximum-subarray/description/
// Coding Ninja Question Link: https://www.naukri.com/code360/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&count=25&page=1&search=&sort_entity=order&sort_order=ASC



class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using 3 Loops) - Time Complexity = O(n^3), SPace Complexity = O(1)
    public int maxSubArray(int[] nums) {
        // Initialize the variable to store the maximum sum found with the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;
        
        // Outer loop to consider each possible starting index of the subarray
        for (int i = 0; i < nums.length; i++) {

            // Inner loop to consider each possible ending index of the subarray
            for (int j = i; j < nums.length; j++) {
                // Initialize the current sum for the subarray from i to j
                int currSum = 0;

                // Inner loop to calculate the sum of the subarray from index i to j
                for (int k = i; k <= j; k++) {
                    currSum += nums[k];
                }

                // Update maxSum if the current sum is greater
                maxSum = Math.max(maxSum, currSum);
            }
        }

        // Return the maximum sum of any subarray
        return maxSum;
    }
    */

    /*
    // 2nd Approach: Better Approach (Using 2 Loops) - Time Complexity = O(n^2), SPace Complexity = O(1)
    public int maxSubArray(int[] nums) {
        // Initialize maxSum with the smallest possible integer value to ensure it can be updated with any subarray sum.
        int maxSum = Integer.MIN_VALUE;
        
        // Iterate over each possible starting index of the subarray
        for (int i = 0; i < nums.length; i++) {

            // Initialize currSum to track the sum of the current subarray
            int currSum = 0;

            // Iterate over each possible ending index of the subarray
            for (int j = i; j < nums.length; j++) {
                // Add the current element to currSum to include it in the subarray
                currSum += nums[j];

                // Update maxSum if currSum is greater than the current maxSum
                maxSum = Math.max(maxSum, currSum);
            }
        }

        // Return the maximum sum found among all subarrays
        return maxSum;
    }
    */


    /*
    // 3rd Approach: Better Approach (Using Prefix Sum Array) - Time Complexity = O(n), SPace Complexity = O(n)
    public int maxSubArray(int[] nums) {

        // Initialize the minimum prefix sum to 0.
        int minPrefixSum = 0;
        
        // Initialize the maximum subarray sum to the smallest possible value.
        int maxSum = Integer.MIN_VALUE;
        
        // Initialize and compute the prefix sum array.
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];     
        }
        
        // Loop through the array, keep track of minimum prefix sum so far and maximum subarray sum.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the maximum subarray sum ending at index i.
            maxSum = Math.max(maxSum, prefixSum[i] - minPrefixSum);
            
            // Update the minimum prefix sum so far.
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }
        
        // Return the maximum subarray sum
        return maxSum;
    }
    */


    // 4th Approach: Optimal Approach (Using Kandane Algorithm) - Time Complexity = O(n), SPace Complexity = O(1)
    public int maxSubArray(int[] nums) {
        // Initialize maxSum to the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;

        // Initialize currSum to 0 for tracking the current subarray sum.
        int currSum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to currSum
            currSum += nums[i];

            // Update maxSum if currSum is greater than maxSum
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            // Reset currSum to 0 if it becomes negative
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // Return the maximum sum of any subarray found
        return maxSum;
    }
}
