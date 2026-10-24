// Question Link: https://leetcode.com/problems/sort-colors/


class Solution {

    /*
    // 1st approach: Brute Force Approach(Using Sorting) - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public void sortColors(int[] nums) {
        // Use the built-in Arrays.sort method to sort the array.
        Arrays.sort(nums);
    }
    */

    /*
    // 2nd Approach: Brute Force Approach (Using Extra Array) - Time Complexity = O(n), Space Complexity = O(n)
    public void sortColors(int[] nums) {
        // Create a temporary array to hold the sorted colors
        int[] temp = new int[nums.length];
        
        // Pointer to keep track of the current index in the temporary array
        int j = 0;  

        // First pass: Copy all 0s (red) to the temporary array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                temp[j] = nums[i]; // Place the 0 at the current index in temp
                j++;  // Move to the next index in the temporary array
            }
        }

        // Second pass: Copy all 1s (white) to the temporary array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp[j] = nums[i]; // Place the 1 at the current index in temp
                j++;  // Move to the next index in the temporary array
            }
        }

        // Third pass: Copy all 2s (blue) to the temporary array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                temp[j] = nums[i]; // Place the 2 at the current index in temp
                j++;  // Move to the next index in the temporary array
            }
        }

        // Copy the sorted array from the temporary array back to the original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i]; // Update the original array with sorted values
        }
    }
    */

    /*
    // 3rd Approach: Better Approach (Using Counting) - Time Complexity = O(n), Space Complexity = O(1)
    public void sortColors(int[] nums) {
        // Count of each color
        int count0 = 0;  // Count of 0s (red)
        int count1 = 0;  // Count of 1s (white)
        int count2 = 0;  // Count of 2s (blue)

        // Traverse through the array to count occurrences of each color
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;  // Increase count of count0, if nums[i] == 0
            } else if (nums[i] == 1) {
                count1++;  // Increase count of count1, if nums[i] == 1
            } else {
                count2++;  // Increase count of count2, if nums[i] == 2
            }
        }

        // Index to fill in the array nums
        int j = 0;

        // Place all 0s (red) in the array nums
        for (int i = 0; i < count0; i++) {
            nums[j++] = 0;
        }

        // Place all 1s (white) in the array nums
        for (int i = 0; i < count1; i++) {
            nums[j++] = 1;
        }

        // Place all 2s (blue) in the array nums
        for (int i = 0; i < count2; i++) {
            nums[j++] = 2;
        }
    }
    */


    // 4th Approach: Optimal Approach (Using Dutch National Flag Method) - Time Complexity = O(n), Space Complexity = O(1)
    public void sortColors(int[] nums) {
        // Initialize pointers
        int low = 0;   // Pointer for the position to place 0s
        int mid = 0;   // Pointer to traverse through the array
        int high = nums.length - 1; // Pointer for the position to place 2s

        // Iterate through the array
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap 0 to the low pointer, move both low and mid pointers forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // 1 is in the correct place, just move the mid pointer forward
                mid++;
            } else {
                // Swap 2 to the high pointer, move the high pointer backward
                swap(nums, mid, high);
                high--;
            }

            /*
            // Switch based on the value at the mid pointer
            switch (nums[mid]) {
                case 0:
                    // Swap 0 to the low pointer, move both low and mid pointers forward
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    // 1 is in the correct place, just move the mid pointer forward
                    mid++;
                    break;
                case 2:
                    // Swap 2 to the high pointer, move the high pointer backward
                    swap(nums, mid, high);
                    high--;
                    break;
            }
            */
        }
    }

    // Helper method to swap elements at indices i and j
    public void swap(int[] nums, int i, int j) {
        // swap by using with the help of extra 3rd variable
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        /*
        // swap without 3rd variable
        if (i != j) { // Check if the indices are different to avoid unnecessary operation
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
        */
    }

}
