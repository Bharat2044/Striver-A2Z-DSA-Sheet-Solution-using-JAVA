// Question Link: https://leetcode.com/problems/move-zeroes/description/


class Solution {
    /*
    // 1st Approach: Using Extra Space - Time Complexity = O(n), Space Complexity = O(n)
    public void moveZeroes(int[] nums) {
        // Length of the array
        int n = nums.length;

        // Create a temporary array to store non-zero elements
        int[] temp = new int[n];

        // Index for placing elements in the `temp` array
        int j = 0; 

        // Iterate through the original array
        for (int i = 0; i < n; i++) {

            // If the current element is not zero, copy it to the temp array
            if (nums[i] != 0) {
                temp[j] = nums[i];

                j++; // Move to the next position in the temp array
            }
        }

        // Copy the elements from the temp array back to the original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
    */

    // 2nd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    public void moveZeroes(int[] nums) {
        // Length of the array
        int n = nums.length;

        // Initialize `j` to track the index of the first zero encountered
        int j = -1;

        // Find the index of the first zero in the array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i; // Update `j` to the current index of zero
                break; // Exit the loop once the first zero is found
            }
        }

        // If no zero was found, return early as the array is already in the desired state
        if (j == -1) {
            return;
        }

        // Process the array starting from the index after the first zero
        for (int i = j + 1; i < n; i++) {
            // If a non-zero element is found
            if (nums[i] != 0) {
                
                // Swap the non-zero element with the zero element found earlier
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                // Move `j` to the next position
                j++;
            }
        }
    }

    /*
    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    public void moveZeroes(int[] nums) {
        // Length of the array
        int n = nums.length;

        // Index to keep track of the position for non-zero elements
        int nonZeroIndex = 0;

        // Iterate through the array to move non-zero elements to the front
        for (int i = 0; i < n; i++) {

            if (nums[i] != 0) {
                // Place the current non-zero element at the `nonZeroIndex` position
                nums[nonZeroIndex] = nums[i];

                // Move `nonZeroIndex` to the next position
                nonZeroIndex++;
            }
        }

        // After placing all non-zero elements, fill the rest of the array with zeros
        for (int i = nonZeroIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
    */
}
