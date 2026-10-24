// Question Link: https://leetcode.com/problems/longest-consecutive-sequence/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach(Using 3 Loops) - Time Complexity = O(n^3), Space Complexity = O(1)
    public int longestConsecutive(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // If the array is empty, return 0 since there are no elements
        if (n == 0) {
            return 0;
        }

        // Initialize the largest sequence length found
        int largest = 1;

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Start a new sequence from the current element
            int x = nums[i];
            int count = 1;

            // Iterate through the array to find the next consecutive elements
            for (int j = 0; j < n; j++) {  // This loop is redundant and can be removed
                for (int k = 0; k < n; k++) {
                    // Check if there is a consecutive element
                    if (x + 1 == nums[k]) {
                        count++;    // Increment the count of consecutive elements
                        x = nums[k]; // Update x to the new consecutive element
                        break;       // Break to find the next consecutive element
                    }
                }
            }

            // Update the largest sequence length found
            largest = Math.max(largest, count);
        }

        // Return the largest consecutive sequence length
        return largest;
    }
    */

    /*
    // 2nd Approach: Brute Force Approach(Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    public static int longestConsecutive(int[] a) {
        int n = a.length; // Get the size of the array
        
        // If the array is empty, return 0 since there are no elements
        if (n == 0) {
            return 0;
        }

        // Initialize the variable to store the length of the longest consecutive sequence
        int longest = 1;

        // Iterate through each element in the array to start a new sequence
        for (int i = 0; i < n; i++) {
            int x = a[i]; // Current element to check for consecutive sequence
            int cnt = 1; // Initialize count for the current sequence

            // Search for consecutive elements starting from x
            while (linearSearch(a, x + 1)) {
                x += 1; // Move to the next consecutive element
                cnt += 1; // Increment the count of consecutive elements
            }

            // Update the longest sequence length found
            longest = Math.max(longest, cnt);
        }

        // Return the length of the longest consecutive sequence found
        return longest;
    }

    public static boolean linearSearch(int[] a, int num) {
        // Get the length of the array
        int n = a.length; 
        
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Check if the current element matches the number we are searching for
            if (a[i] == num) {
                return true; // Number found, return true
            }
        }
        
        // Number not found, return false
        return false;
    }
    */
    

    /*
    // 3rd Approach: Better Approach(Using Sorting) - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public int longestConsecutive(int[] nums) {
        // Get the length of the input array
        int n = nums.length;

        // If the array is empty, return 0 since there are no elements
        if (n == 0) {
            return 0;
        }

        // Sort the array to bring consecutive elements next to each other
        Arrays.sort(nums);

        // Initialize a variable to keep track of the last smaller number in the sequence
        int lastSmaller = Integer.MIN_VALUE;

        // Initialize count for the current consecutive sequence length
        int count = 1;

        // Initialize the longest sequence length found so far
        int longest = 1;

        // Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            // Check if the current number is consecutive to the last smaller number
            if (nums[i] - 1 == lastSmaller) {
                count++; // Increment the count as the sequence is extended
                lastSmaller = nums[i]; // Update the last smaller number to the current number
            } else if (nums[i] != lastSmaller) {
                // If the current number is not equal to the last smaller number,
                // reset the count to 1 as this starts a new sequence
                count = 1;
                lastSmaller = nums[i]; // Update the last smaller number to the current number
            }

            // Update the longest sequence length if the current count is greater
            longest = Math.max(longest, count);
        }

        // Return the length of the longest consecutive sequence found
        return longest;
    }
    */

    // 4th Approach: Optimal Approach(Using HashSet) - Time Complexity = O(n), Space Complexity = O(n)
    public static int longestConsecutive(int[] nums) {
        // If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Create a HashSet to store all elements
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Iterate through each element in the array
        for (int it : set) {

            // Check if the current number is the start of a sequence
            if (!set.contains(it - 1)) {
                int currentNum = it;
                int count = 1;

                // Count consecutive elements starting from currentNum
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // Update the length of the longest consecutive sequence
                longest = Math.max(longest, count);
            }
        }

        // Return the length of the longest consecutive sequence found
        return longest;
    }
}
