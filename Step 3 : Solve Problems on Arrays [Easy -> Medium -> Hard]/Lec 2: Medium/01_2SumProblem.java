// Question Link: https://leetcode.com/problems/two-sum/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    public int[] twoSum(int[] nums, int target) {

        // Iterate through each element in the array, except the last one
        for (int i = 0; i < nums.length - 1; i++) {

            // For each element, iterate through the remaining elements to the right
            for (int j = i + 1; j < nums.length; j++) {

                // Check if the current pair of elements sum up to the target
                if (nums[i] + nums[j] == target) {
                    // Return the indices of the two elements that sum up to the target
                    return new int[]{i, j};
                }
            }
        }

        // Return {-1, -1} if no valid pair is found
        return new int[]{-1, -1};
    }
    */

    // 2nd Approach: Optimal Approach (Using HashMap) - Time Complexity = O(n), Space Complexity = O(n)
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers and their corresponding indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the number needed to reach the target sum
            int moreNeeded = target - nums[i];

            // Check if the HashMap contains the needed number
            if (map.containsKey(moreNeeded)) {
                // If found, return the indices of the current number and the needed number
                return new int[]{i, map.get(moreNeeded)};
            }

            // Store the current number and its index in the HashMap
            map.put(nums[i], i);
        }

        // Return {-1, -1} if no valid pair is found
        return new int[]{-1, -1};
    }
}
