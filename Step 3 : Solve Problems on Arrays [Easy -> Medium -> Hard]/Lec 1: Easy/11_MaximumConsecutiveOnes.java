// Question Link: https://leetcode.com/problems/max-consecutive-ones/description/


class Solution {
    /*
    // 1st Approach: Direct Iteration - Time Complexity = O(n), Space Complexity = O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        // Initialize variables to track the maximum length of consecutive 1's and the current length
        int maxCount = 0;        // Variable to keep track of the maximum number of consecutive 1's found so far
        int currentCount = 0;    // Variable to keep track of the current length of consecutive 1's

        // Traverse through the array to find the maximum number of consecutive 1's
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // If the current element is 1, increment the current streak counter
                currentCount++;
            } else {
                // If the current element is 0, update maxCount if the current streak is longer
                maxCount = Math.max(maxCount, currentCount);
                // Reset currentCount as the streak of 1's has been interrupted
                currentCount = 0;
            }
            
            // Update maxCount in each iteration to account for the longest streak found so far
            maxCount = Math.max(maxCount, currentCount);
        }

        // Return the maximum number of consecutive 1's found
        return maxCount;
    }
    */

    // 2nd Approach: Using Stack - Time Complexity = O(n), Space Complexity = O(n)
    public int findMaxConsecutiveOnes(int[] nums) {
        // Stack to keep track of indices of 1's
        Stack<Integer> stack = new Stack<>(); 

        // Variable to store the maximum length of consecutive 1's
        int maxCount = 0;                    

        // Traverse through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is 1, push its index onto the stack
            if (nums[i] == 1) {
                stack.push(i);
            } else {
                // If the current element is 0, clear the stack as the streak of 1's is interrupted
                if (!stack.isEmpty()) {
                    stack.clear();
                }
            }

            // Update maxCount to be the maximum size of the stack, representing the longest streak of 1's found so far
            maxCount = Math.max(maxCount, stack.size());
        }

        // Return the maximum length of consecutive 1's found
        return maxCount;
    }
}
