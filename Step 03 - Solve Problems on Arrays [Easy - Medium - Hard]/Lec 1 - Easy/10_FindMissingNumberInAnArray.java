// Question Link: https://leetcode.com/problems/missing-number/description/


class Solution {
    /*
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
    */

    /*
    // 2nd Approach: Using Array Hashing - Time Complexity = O(n), Space Complexity = O(n)
    public int missingNumber(int[] nums) {

        // Create an array to track the presence of each number in the range [0, nums.length]
        // Array length is nums.length + 1 to account for all possible numbers including the missing one
        int[] freq = new int[nums.length + 1];

        // Iterate through each number in the input array
        for (int i = 0; i < nums.length; i++) {
            // Increment the count for the current number in the 'freq' array
            // 'nums[i]' is used as the index to mark presence
            freq[nums[i]]++;
        }

        // Iterate through numbers from 0 to nums.length - 1 to find the missing number
        for (int i = 0; i < nums.length; i++) {
            // If the frequency of number 'i' is 0, it means 'i' is missing from the array
            if (freq[i] == 0) {
                // Return the missing number 'i'
                return i;
            }
        }

        // If no missing number was found in the range [0, nums.length - 1], return nums.length
        // This handles the case where the missing number is 'nums.length'
        return nums.length;
    }
    */

    /*
    // 3rd Approach: Using HashMap - Time Complexity = O(n), Space Complexity = O(n)
    public int missingNumber(int[] nums) {

        // Create a HashMap to keep track of the presence of each number in the array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Update the map with the count of each number; here, we only need presence, so we use count + 1
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // Alternative approach: The following commented code performs the same operation as the line above but with more steps
            // if (map.containsKey(nums[i])) {
            //     map.put(nums[i], map.get(nums[i]) + 1);
            // } else {
            //     map.put(nums[i], 1);
            // }
        }

        // Iterate through numbers from 0 to nums.length - 1 to find the missing number
        for (int i = 0; i < nums.length; i++) {
            // Check if the number 'i' is not present in the map
            if (map.containsKey(i) == false) {
                // Return 'i' as it is the missing number
                return i;
            }
        }

        // If no missing number was found in the range [0, nums.length - 1], return nums.length
        // This handles the case where the missing number is 'nums.length'
        return nums.length;
    }
    */

    /*
    // 4th Approach: Using Sorting - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public int missingNumber(int[] nums) {

        // Sort the array in ascending order
        Arrays.sort(nums);

        // Iterate through each index from 0 to nums.length - 1
        for (int i = 0; i < nums.length; i++) {
            // If the number at index 'i' is not equal to 'i', it means 'i' is the missing number
            if (nums[i] != i) {
                return i;   // Return 'i' as it is the missing number
            }
        }

        // If no missing number was found in the range [0, nums.length - 1], return nums.length
        // This handles the case where the missing number is 'nums.length'
        return nums.length;
    }
    */

    /*
    // 5th Approach: Using Formula - Time Complexity = O(n), Space Complexity = O(1)
    public int missingNumber(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Calculate the sum of the first 'n' natural numbers (0 to n) using the formula: n * (n + 1) / 2
        int sum = (n * (n + 1)) / 2;

        // Initialize a variable to hold the sum of the elements in the input array
        int arrSum = 0;

        // Iterate through the input array to calculate the sum of its elements
        for (int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
        }

        // The missing number is the difference between the expected sum and the actual sum
        // Return the missing number
        return sum - arrSum;
    }
    */


    // 6th Approach: Using Bitwise XOR - Time Complexity = O(n), Space Complexity = O(1)
    public int missingNumber(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // Initialize a variable to hold the result of XOR operations
        int ans = 0;

        // Perform XOR for all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            ans = ans ^ i; // XOR with each number in the range [1, n]
        }

        // Perform XOR for all numbers present in the input array
        for (int i = 0; i < n; i++) {
            ans = ans ^ nums[i]; // XOR with each number in the array
        }

        // The result of XOR operations will be the missing number
        // Return the missing number
        return ans;
    }
}
