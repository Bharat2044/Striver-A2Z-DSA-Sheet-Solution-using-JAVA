// Question Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Extra Space) - Time Complexity = O(n), Space Complexity = O(n)
    public int[] rearrangeArray(int[] nums) {
        // Create a new array to store the rearranged elements.
        int[] ans = new int[nums.length];

        // Create two lists to store positive and negative numbers separately.
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Iterate through the input array.
        for (int i = 0; i < nums.length; i++) {
            // If the number is positive, add it to the positive list.
            if (nums[i] > 0) {
                positive.add(nums[i]);
            } else {
                // If the number is negative, add it to the negative list.
                negative.add(nums[i]);
            }
        }

        // Iterate through half the length of the input array (since it's even length).
        for (int i = 0; i < nums.length / 2; i++) {
            // Place a positive number at the even index.
            ans[2 * i] = positive.get(i);

            // Place a negative number at the odd index.
            ans[2 * i + 1] = negative.get(i);
        }

        // Return the rearranged array.
        return ans;
    }
    */

    /*
    // 2nd Approach: Brute Force Approach (Using Extra Space, but one list) - Time Complexity = O(n), Space Complexity = O(n)
    public int[] rearrangeArray(int[] nums) {
        // Create a new array to store the rearranged elements.
        int[] ans = new int[nums.length];

        // Create a list to store negative numbers.
        ArrayList<Integer> negative = new ArrayList<>();

        // Iterate through the input array.
        for (int i = 0; i < nums.length; i++) {

            // If the number is negative, add it to the negative list.
            if (nums[i] < 0) {
                negative.add(nums[i]);
            }
        }

        // Initialize two pointers: j for the new array index and k for the negative list index.
        int j = 0;
        int k = 0;

        // Iterate through the input array again.
        for (int i = 0; i < nums.length; i++) {

            // If the number is positive, place it in the new array.
            if (nums[i] > 0) {
                ans[j++] = nums[i];  // Place positive number at the current j and then increment j.
                ans[j++] = negative.get(k++);  // Place corresponding negative number at the next j and then increment both j and k.
            }
        }

        // Return the rearranged array.
        return ans;
    }
    */


    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(n)
    public int[] rearrangeArray(int[] nums) {
        // Create a new array to store the rearranged elements.
        int[] ans = new int[nums.length];

        // Initialize posIndex to start at 0 for positive numbers.
        int posIndex = 0;

        // Initialize negIndex to start at 1 for negative numbers.
        int negIndex = 1;

        // Iterate through the input array.
        for (int i = 0; i < nums.length; i++) {
            // If the current number is positive,
            if (nums[i] > 0) {
                // place it at the current posIndex in ans array.
                ans[posIndex] = nums[i];

                // Increment posIndex by 2 to point to the next even index.
                posIndex += 2;
            } else { // If the current number is negative,
                // place it at the current negIndex in ans array.
                ans[negIndex] = nums[i];
                
                // Increment negIndex by 2 to point to the next odd index.
                negIndex += 2;
            }
        }

        // Return the rearranged array.
        return ans;
    }
}
