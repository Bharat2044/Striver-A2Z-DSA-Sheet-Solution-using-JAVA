// Question Link: https://leetcode.com/problems/4sum/description/

class Solution {
    /*
    // 1st Approach: Brute Force Approach(Using 4 Loops) - Time Complexity = O(n^4), Space Complexity = O(n^2)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Get the length of the input array
        int n = nums.length; 

        // Initialize a set to store unique quadruplets
        Set<List<Integer>> set = new HashSet<>();

        // Iterate over the array with four nested loops to pick all quadruplets
        for (int i = 0; i < n; i++) { // First index
            for (int j = i + 1; j < n; j++) { // Second index
                for (int k = j + 1; k < n; k++) { // Third index

                    for (int l = k + 1; l < n; l++) { // Fourth index
                        // Compute the sum of the current quadruplet
                        long sum = (long)nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        // Check if the computed sum matches the target
                        if (sum == target) {
                            // Create a list of the current quadruplet
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);

                            // Sort the list to ensure the order of elements does not affect uniqueness
                            Collections.sort(temp);

                            // Add the sorted list to the set to ensure uniqueness
                            set.add(temp);
                        }
                    }
                }
            }
        }
        
        // Convert the set of unique quadruplets to a list
        List<List<Integer>> ans = new ArrayList<>(set);

        // Return the list
        return ans;
    }
    */

    /*
    // 2nd Approach: Better Approach (Using 3 Loops and HashSet) - Time Complexity = O(n^2), Space Complexity = O(n^2)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Get the length of the array
        int n = nums.length; 

        // To store unique quadruplets
        Set<List<Integer>> set = new HashSet<>(); 

        // Checking all possible pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                Set<Long> hashset = new HashSet<>(); // HashSet to store potential fourth elements
                
                for (int k = j + 1; k < n; k++) {
                    // Calculate the sum of the first three elements
                    long sum = nums[i] + nums[j];
                    sum += nums[k];

                    // Calculate the required fourth element
                    long fourth = target - sum; 

                    // Check if the fourth element is present in the HashSet
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        temp.add((int) fourth);
                        
                        Collections.sort(temp); // Sort to ensure uniqueness
                        set.add(temp); // Add the sorted quadruplet to the HashSet
                    }

                    // Add the current element to the HashSet
                    hashset.add((long) nums[k]);
                }
            }
        }
        
        // Convert the HashSet to a List
        List<List<Integer>> ans = new ArrayList<>(set);

        // return the list
        return ans;
    }
    */

    // 3rd Approach: Optimal Approach (Using Sorting ans 2 Pointers) - Time Complexity = O(n^2), Space Complexity = O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // Size of the array
        List<List<Integer>> ans = new ArrayList<>(); // List to store the final quadruplets

        // Sort the array to enable the two-pointer technique
        Arrays.sort(nums);

        // Iterate through all possible first elements of the quadruplet
        for (int i = 0; i < n; i++) {

            // Skip duplicate elements for the first number to avoid redundant quadruplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Iterate through all possible second elements of the quadruplet
            for (int j = i + 1; j < n; j++) {

                // Skip duplicate elements for the second number to avoid redundant quadruplets
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Initialize two pointers for the remaining two elements
                int k = j + 1; // Left pointer starts just after the second element
                int l = n - 1; // Right pointer starts at the end of the array
                
                // Use two-pointer technique to find the remaining two elements
                while (k < l) {

                    // Calculate the sum of the current quadruplet
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    
                    if (sum == target) {
                        // If the sum matches the target, add the quadruplet to the result list
                        List<Integer> temp = new ArrayList<>();

                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);

                        ans.add(temp);
                        
                        k++; // Move the left pointer to the right
                        l--; // Move the right pointer to the left

                        // Skip duplicate values for the third element
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        // Skip duplicate values for the fourth element
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        // If the sum is less than the target, increase the sum by moving the left pointer to the right
                        k++;
                    } else {
                        // If the sum is greater than the target, decrease the sum by moving the right pointer to the left
                        l--;
                    }
                }
            }
        }
        
        // Return the list of unique quadruplets
        return ans; 
    }
}

