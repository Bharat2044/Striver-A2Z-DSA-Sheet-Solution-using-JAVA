// Question Link: https://leetcode.com/problems/majority-element-ii/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using 3 Loops) - Time Complexity = O(n^2), Space Complexity =  O(n)
    public List<Integer> majorityElement(int[] nums) {
        // List to store result
        List<Integer> ans = new ArrayList<>(); 

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Initialize count for the current element
            int count = 0; 

            // Count occurrences of nums[i] in the array
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++; // Increment count if nums[i] is found
                }
            }

            // Check if the count of nums[i] is greater than n/3 and it's not already in the result list
            if ((count > (nums.length / 3)) && (!ans.contains(nums[i]))) {
                ans.add(nums[i]); // Add the element to the result list
            }
        }

        return ans; // Return the result list
    }
    */


    /*
    // 2nd Approach: Better Approach (Using Sorting) - Time Complexity = O(n * log(n)), Space Complexity =  O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(); // List to store result

        Arrays.sort(nums); // Sort the array to bring duplicates together

        int count = 0; // Initialize count to track occurrences of the current element
        int ele = nums[0]; // Initialize the first element as the current element to compare against

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele) {
                count++; // Increment count if the current element matches the previous one
            } else {
                ele = nums[i]; // Update the current element when a new element is encountered
                count = 1;     // Reset the count for the new element
            }

            // Check if the current element has appeared more than n/3 times
            if (count == (nums.length / 3) + 1) {
                ans.add(ele); // Add the element to the result list
            }
        }

        return ans; // Return the result list
    }
    */ 


    /*
    // 3rd Approach: Better Approach (Using Hashing) - Time Complexity = O(n), Space Complexity =  O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>(); // List to store result

        // HashMap to store the frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Get the current count of nums[i], default to 0 if it doesn't exist
            int value = map.getOrDefault(nums[i], 0);

            // Update the count of nums[i] in the map
            map.put(nums[i], value + 1);

            // Check if nums[i] appears more than n/3 times
            // If so, add it to the result list
            // This condition also ensures that elements are added only once when their count exceeds the threshold
            if (map.get(nums[i]) == (nums.length / 3) + 1) {
                ans.add(nums[i]); 
            }
        }

        return ans; // Return the result list
    }
    */


    // 4th Approach: Optimal Approach (Using (Extended Boyer Moore’s Voting Algorithm) - Time Complexity = O(n), Space Complexity =  O(1)
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = 0, ele2 = 0; // Potential majority elements
        int count1 = 0, count2 = 0; // Counters for potential majority elements

        // First pass: Identify potential candidates for majority elements
        for (int num : nums) {
            if (num == ele1) {
                count1++; // Increment count for ele1 if it's the current element
            } else if (num == ele2) {
                count2++; // Increment count for ele2 if it's the current element
            } else if (count1 == 0) {
                ele1 = num; // Set a new candidate for ele1 when count1 is 0
                count1 = 1; // Initialize count1 for the new candidate
            } else if (count2 == 0) {
                ele2 = num; // Set a new candidate for ele2 when count2 is 0
                count2 = 1; // Initialize count2 for the new candidate
            } else {
                count1--; // Decrease both counts when the current element matches neither candidate
                count2--;
            }
        }

        // Second pass: Verify the candidates by counting their actual occurrences
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == ele1) { // Count occurrences of ele1
                count1++; 
            } else if (num == ele2) { // Count occurrences of ele2
                count2++;
            }
        }

        // Prepare the result list
        List<Integer> result = new ArrayList<>();

        // Add ele1 to result if it appears more than n/3 times
        if (count1 > nums.length / 3) {
            result.add(ele1); 
        }

        // Add ele2 to result if it appears more than n/3 times
        if (count2 > nums.length / 3) {
            result.add(ele2); 
        }

        return result; // Return the list of majority elements
    }
}
