// Question Link: https://leetcode.com/problems/sum-of-subarray-ranges/description/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(n^2), Space Complexity = O(1)
    public long subArrayRanges(int[] nums) {
    
        // Initialize sumOfRanges to store the total sum of ranges of all subarrays
        long sumOfRanges = 0;

        // Outer loop to set the starting point of each subarray
        for (int i = 0; i < nums.length; i++) {
            // Initialize minVal and maxVal for the current subarray
            int minVal = nums[i];
            int maxVal = nums[i];
            
            // Inner loop to expand the subarray and update min and max values
            for (int j = i; j < nums.length; j++) {
                // Update minVal to the smallest element in the current subarray
                minVal = Math.min(minVal, nums[j]);
                
                // Update maxVal to the largest element in the current subarray
                maxVal = Math.max(maxVal, nums[j]);
                
                // Add the range (difference between max and min) of the current subarray to sumOfRanges
                sumOfRanges += (maxVal - minVal);
            }
        }

        // Return the total sum of ranges for all subarrays
        return sumOfRanges;
    }
    */


    // 2nd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(n)
    public long subArrayRanges(int[] nums) {
        // Get the length of the nums array
        int n = nums.length;

        // Initialize variable to store the total sum of ranges
        long sumOfRanges = 0;  

        // Stack to find previous and next less elements for each element
        Stack<Integer> stack = new Stack<>();

        // Calculate each element's contribution when it's the minimum in a subarray
        long[] minContribution = new long[n];  // Array to store minimum contributions
        
        for (int i = 0; i <= n; i++) {
           
            // Process until finding smaller element or end of array
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] >= nums[i])) {
                // Index of current element
                int j = stack.pop();  

                // Previous less element's index
                int left = stack.isEmpty() ? -1 : stack.peek();  

                // Contribution calculation: nums[j] is minimum in (j-left) * (i-j) subarrays
                minContribution[j] = (long) nums[j] * (j - left) * (i - j);
            }

            // Push current index to stack for future calculations
            stack.push(i);  
        }

        // Clear stack to reuse it for maximum contribution calculation
        stack.clear();

        // Calculate each element's contribution when it's the maximum in a subarray
        long[] maxContribution = new long[n];  // Array to store maximum contributions
        for (int i = 0; i <= n; i++) {
           
            // Process until finding larger element or end of array
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] <= nums[i])) {
                // Index of current element
                int j = stack.pop();  
                
                // Previous greater element's index
                int left = stack.isEmpty() ? -1 : stack.peek();  
                
                // Contribution calculation: nums[j] is maximum in (j-left) * (i-j) subarrays
                maxContribution[j] = (long) nums[j] * (j - left) * (i - j);
            }
            
            // Push current index to stack for future calculations
            stack.push(i);  
        }

        // Sum all maximum and minimum contributions to get the final sum of ranges
        for (int i = 0; i < n; i++) {
            sumOfRanges += maxContribution[i] - minContribution[i];
        }

        // Return the final result
        return sumOfRanges;  
    }
}
