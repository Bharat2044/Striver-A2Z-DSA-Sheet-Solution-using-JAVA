// Question Link: https://leetcode.com/problems/single-number/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    public int singleNumber(int[] nums) {
        // Iterate over each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Initialize a counter for occurrences of the current element
            int count = 0;
            
            // Count occurrences of nums[i] in the entire array
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // If the count is 1, the current element is the single number
            if (count == 1) {
                return nums[i];
            }
        }

        // If no single number is found, return -1
        return -1;
    }
    */

    /*
    // 2nd Approach: Brute Force Approach (Using Sorting) - Time Complexity = O(n * long(n)), Space Complexity = O(1)
    public int singleNumber(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        // Traverse the sorted array
        for (int i = 0; i < nums.length - 1; i += 2) {
            // Check if the current element is not equal to the next element
            if (nums[i] != nums[i + 1]) {
                // Return the current element as it is the single number
                return nums[i];
            }
        }
        
        // If no single number is found in the loop, the last element is the single number
        return nums[nums.length - 1];
    }
    */

    /*
    // 3rd Approach: Better Approach (Using HashMap) - Time Complexity = O(n), Space Complexity = O(n)
    public int singleNumber(int[] nums) {
        // Create a HashMap to store the frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Traverse through the array and populate the HashMap
        for (int num : nums) {
            int freq = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, freq + 1);
        }

        // Traverse through the array to find the number with frequency 1
        for (int num : nums) { 
            if (frequencyMap.get(num) == 1) { 
                return num; 
            } 
        } 
        
        // Traverse through the HashMap to find the key with frequency 1
        // for (int key : frequencyMap.keySet()) {
        //     if (frequencyMap.get(key) == 1) {
        //         return key;
        //     }
        // }
        
        // Return -1 if no single number is found
        return -1;
    }
    */

    // 4th Approach: Optimal Approach (Bitwise XOR) - Time Complexity = O(n), Space Complexity = O(1)
    public int singleNumber(int[] nums) {
        // Initialize a variable to hold the XOR result
        int xor = 0;

        // Traverse through the array
        // 0 ^ 0 = 0, 1 ^ 1 = 0, 1 ^ 0 = 1, 0 ^ 1 = 1,
        // a ^ a = 0
        for (int i = 0; i < nums.length; i++) {
            // XOR the current element with the result
            xor ^= nums[i];
        }
        
        // The result will be the single number
        return xor;
    }
}
