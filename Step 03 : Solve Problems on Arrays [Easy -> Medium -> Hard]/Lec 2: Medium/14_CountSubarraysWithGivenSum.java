// Question Link: https://leetcode.com/problems/subarray-sum-equals-k/description/


class Solution {

    /*
    // 1st Approach: Brute Force Approach (Using 3 Loops) - Time Complexity = O(n^3), Space Complexity = O(1)
    public int subarraySum(int[] nums, int k) {
        
        // Get the length of the input array
        int n = nums.length;

        // Initialize count to store the number of subarrays with sum equals to k
        int count = 0;

        // Iterate over all possible starting points of subarrays
        for (int i = 0; i < n; i++) {
            // Iterate over all possible ending points of subarrays starting from i
            for (int j = i; j < n; j++) {

                // Initialize sum for the current subarray
                int sum = 0;

                // Calculate the sum of elements from index i to j
                for (int x = i; x <= j; x++) {
                    sum += nums[x];
                }

                // If the sum equals k, increment the count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return the total count of subarrays whose sum equals to k
        return count;
    }
    */

    /*
    // 2nd Approach: Better Approach (Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    public int subarraySum(int[] nums, int k) {
        
        // Get the length of the input array
        int n = nums.length;

        // Initialize count to store the number of subarrays with sum equals to k
        int count = 0;

        // Iterate over all possible starting points of subarrays
        for (int i = 0; i < n; i++) {
            // Initialize sum for the current subarray starting at index i
            int sum = 0;

            // Iterate over all possible ending points of subarrays starting from i
            for (int j = i; j < n; j++) {
                // Add the current element to the sum
                sum += nums[j];

                // If the sum equals k, increment the count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return the total count of subarrays whose sum equals to k
        return count;
    }
    */


    // 3rd Approach: Optimal Approach (Using HashMap) - Time Complexity = O(n), Space Complexity = O(1)
    public int subarraySum(int[] nums, int k) {
        
        // Get the length of the input array
        int n = nums.length;

        // Initialize the hash map to store the cumulative sum and its frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // This will track the sum of elements from the start of the array up to the current index
        int preSum = 0;
        
        // This will keep track of the total number of subarrays whose sum equals k
        int count = 0;

        // Put the initial prefix sum (0) in the hash map with a count of 1
        map.put(0, 1);

        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Update the cumulative sum
            preSum += nums[i];

            // Calculate the sum that needs to be removed to get the target sum k
            int remove = preSum - k;

            // Add the number of subarrays found with the required sum to the count
            if (map.containsKey(remove)) {
                count += map.get(remove);
            }

            // Update the hash map with the current cumulative sum
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        // Return the total count of subarrays whose sum equals k
        return count;
    }
}
