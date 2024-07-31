// Question Link: https://leetcode.com/problems/missing-number/description/


class Solution {
    // 1st Approach: Using 2 Loops - Time Complexity = O(n ^ 2), Space Complexity = O(1)
    public int missingNumber(int[] nums) {
        // Iterate through each possible number from 0 to nums.length
        for (int i = 0; i < nums.length; i++) {
            // Initialize a flag to check if the current number 'i' is found in the array
            boolean flag = false;

            // Check if the current number 'i' is present in the array
            for (int j = 0; j < nums.length; j++) {
                // If the number 'i' is found in the array, set the flag to true and exit the inner loop
                if (nums[j] == i) {
                    flag = true;
                    break;
                }
            }

            // If the number 'i' was not found in the array, it is the missing number
            if (flag == false) {
                return i; // Return the missing number
            }
        }

        // If no missing number was found in the range [0, nums.length - 1], return nums.length
        // This case handles the situation where the missing number is 'nums.length'
        return nums.length;
    }
}
