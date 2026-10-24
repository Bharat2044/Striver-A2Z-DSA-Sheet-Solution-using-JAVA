// Question Link: https://leetcode.com/problems/3sum/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach(Using 3 Loops) - Time Complexity = O(n^3), Space Complexity = O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        // Create a set to store unique triplets that sum to zero.
        Set<List<Integer>> set = new HashSet<>();

        // Iterate over the array with the first index i.
        for (int i = 0; i < nums.length - 2; i++) {

            // Iterate over the array with the second index j, starting from i+1.
            for (int j = i + 1; j < nums.length - 1; j++) {

                // Iterate over the array with the third index k, starting from j+1.
                for (int k = j + 1; k < nums.length; k++) {

                    // Check if the sum of the elements at indices i, j, and k is zero.
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        // Create a list containing the triplet.
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);

                        // Sort the triplet to ensure uniqueness (i.e., avoid [a, b, c] and [c, b, a] being considered different).
                        triplet.sort(null);

                        // Add the sorted triplet to the set, ensuring no duplicates are added.
                        set.add(triplet);
                    }
                }
            }
        }

        // Convert the set of unique triplets into a list.
        List<List<Integer>> ans = new ArrayList<>(set);
        
        // Return the list of unique triplets.
        return ans;
    }
    */

    /*
    // 2nd Approach: Better Approach (Using HashSet) - Time Complexity = O(n^2), Space Complexity = O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {

        // Initialize a set to store unique triplets that sum to zero.
        Set<List<Integer>> set = new HashSet<>();
        
        // Iterate through the array, fixing one element at a time.
        for (int i = 0; i < nums.length - 2; i++) {
            // Initialize a set to keep track of elements we have seen in this iteration.
            Set<Integer> seen = new HashSet<>();
            
            // Iterate through the array starting from the element after the fixed one.
            for (int j = i + 1; j < nums.length; j++) {
                
                // Calculate the complement that, when added to nums[i] and nums[j], anss in zero.
                int complement = -nums[i] - nums[j];
                
                // Check if the complement is already in the set (i.e., we have seen it before).
                if (seen.contains(complement)) {
                    // If we found the complement, this means we have a valid triplet.
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    
                    // Sort the triplet to ensure the order is consistent and prevent duplicates.
                    triplet.sort(null);
                    
                    // Add the sorted triplet to the set of unique triplets.
                    set.add(triplet);
                }
                
                // Add the current element to the set of seen elements.
                seen.add(nums[j]);
            }
        }
        
        // Convert the set of unique triplets into a list and return it.
        return new ArrayList<>(set);
    }
    */

    // 3rd Approach: Optimal Approach (Using Sorting ans 2 Pointers) - Time Complexity = O(n^2), Space Complexity = O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        // Initialize the ans list to store the triplets.
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sort the array to enable the two-pointer technique.
        Arrays.sort(nums);
        
        // Iterate through the array, fixing one element at a time.
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets in the ans.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Initialize two pointers:
            // 'left' starts from the next element after the fixed element.
            int left = i + 1;
            // 'right' starts from the end of the array.
            int right = nums.length - 1;
            
            // Move the two pointers inward to find pairs that sum to -nums[i].
            while (left < right) {
                // Calculate the sum of the triplet.
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // If the sum is zero, we found a valid triplet.
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate elements to avoid duplicate triplets in the ans.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    // Move both pointers inward after finding a valid triplet.
                    left++;
                    right--;
                } else if (sum < 0) {
                    // If the sum is less than zero, move the left pointer to the right to increase the sum.
                    left++;
                } else {
                    // If the sum is greater than zero, move the right pointer to the left to decrease the sum.
                    right--;
                }
            }
        }
        
        // Return the list of unique triplets.
        return ans;
    }
}
