// Question Link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach(Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    public int singleNonDuplicate(int[] nums) {
        
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            
            // Initialize a count variable to keep track of the occurrences of nums[i]
            int count = 0;

            // Inner loop to compare nums[i] with every other element in the array
            for (int j = 0; j < nums.length; j++) {
                
                // If a match is found, increment the count
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            // If the count is 1, it means nums[i] is the unique element that appears only once
            if (count == 1) {
                return nums[i]; // Return the unique element
            }
        }

        // In case no unique element is found, return -1 as a fallback
        return -1;
    }
    */

    /*
    // 2nd Approach: Brute Force Approach(Using HashMap) - Time Complexity = O(n), Space Complexity = O(n)
    public int singleNonDuplicate(int[] nums) {
        // Create a HashMap to store the count of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Populate the HashMap with counts of each element
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;

            map.put(num, count);
        }

        // Iterate through the HashMap to find the element with a count of 1
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key; // Return the element that appears only once
            }
        }

        // Return -1 as a fallback (though, by problem constraints, this should never happen)
        return -1;
    }
    */

    /*
    // 3rd Approach: Better Approach(Using 1 Loop) - Time Complexity = O(n), Space Complexity = O(1)
    public int singleNonDuplicate(int[] nums) {

        // Initialize the previousElement to the first element of the array
        int previousElement = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is the same as the previous one
            if (nums[i] == previousElement) {
                // If it's the same, skip to the next pair, Move to the next element after the pair
                i++;

                // Update previousElement to the next unpaired element (if within bounds)
                if (i < nums.length) {
                    previousElement = nums[i];
                }
            } else {
                // If the current element is not the same as the previous one, return the previous element
                return previousElement;
            }
        }

        // If the loop ends without finding the single element, the last element is the unique one
        return previousElement;
    }
    */

    /*
    // 4th Approach: Better Approach(Using Bitwise XOR) - Time Complexity = O(n), Space Complexity = O(1)
    public int singleNonDuplicate(int[] nums) {
        // Initialize the result variable to 0
        int result = 0;

        // XOR all the elements in the array
        for (int num : nums) {
            result ^= num; // result = result ^ num
        }

        // The result will hold the unique element
        return result;
    }
    */

    // 5th Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    public int singleNonDuplicate(int[] nums) {

        // Initialize left pointer to the start of the array
        int left = 0;
        
        // Initialize right pointer to the end of the array
        int right = nums.length - 1;

        // Perform binary search until left pointer meets the right pointer
        while (left < right) {

            // Calculate mid-point to split the array
            int mid = left + (right - left) / 2;

            // If mid is odd, adjust it to be even for proper pair checking
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the current mid element is paired with the next element
            if (nums[mid] == nums[mid + 1]) {
                // If mid element is paired with the next, move left pointer to mid + 2
                // to search in the right half
                left = mid + 2;
            } else {
                // If mid element is not paired, the unique element is in the left half
                // Move the right pointer to mid
                right = mid;
            }
        }

        // Return the element at the left pointer, which is the unique element
        return nums[left];
    }
}
