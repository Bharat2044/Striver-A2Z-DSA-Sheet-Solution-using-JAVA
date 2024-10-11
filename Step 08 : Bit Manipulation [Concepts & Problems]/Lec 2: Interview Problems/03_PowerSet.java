// Question Link: https://leetcode.com/problems/subsets/


class Solution {
    /*
    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add the current subset to the result list (copy of currentSubset)
        result.add(new ArrayList<>(currentSubset));

        // Iterate through each element starting from 'start'
        for (int i = start; i < nums.length; i++) {
            // Include nums[i] in the current subset
            currentSubset.add(nums[i]);
            
            // Recursively call backtrack to generate all further subsets including nums[i]
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack by removing the last element to explore subsets without nums[i]
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    // 1st Approach - Time Complexity = O(2^n), Space Complexity = O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize the result list to store all subsets
        List<List<Integer>> result = new ArrayList<>();
        
        // Call the backtrack function with an empty list (currentSubset) and starting index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        
        // Return the result containing all subsets
        return result;
    }
    */


    // 2nd Approach - Time Complexity = O(2^n), Space Complexity = O(2^n)
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize result list to store all subsets
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets (using bitwise shift)

        // Iterate through all possible binary numbers from 0 to 2^n - 1
        for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
            List<Integer> currentSubset = new ArrayList<>();

            // Check each bit of subsetMask to determine which elements to include
            for (int i = 0; i < n; i++) {
                // if the ith bit is set
                if ((subsetMask & (1 << i)) != 0) { 
                    currentSubset.add(nums[i]);     // include nums[i] in the subset
                }
            }

            // Add the current subset to the result list
            result.add(currentSubset);
        }

        // Return all subsets
        return result;
    }
}
