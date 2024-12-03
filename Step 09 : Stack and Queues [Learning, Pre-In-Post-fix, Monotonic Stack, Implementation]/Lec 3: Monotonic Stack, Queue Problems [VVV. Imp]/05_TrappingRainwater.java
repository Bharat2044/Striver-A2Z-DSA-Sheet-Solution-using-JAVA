// Question Link: https://leetcode.com/problems/trapping-rain-water/description/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(n^2), Space Complexity = O(1)
    public int trap(int[] height) {
        // Get the length of the height array
        int n = height.length; 

        // Variable to store the total trapped water
        int waterTrapped = 0;  

        // Step 2: Traverse each bar in the heightay to calculate trapped water
        for (int i = 0; i < n; i++) {
            int j = i;
        
            // Step 3: Find the maximum height to the left of the current bar
            int leftMax = 0; // Initialize the left max height to 0

            while (j >= 0) {
                leftMax = Math.max(leftMax, height[j]); // Update leftMax as the maximum between leftMax and height[j]
                j--; // Move to the previous bar on the left
            }

            j = i; // Reset j to the current index for right side calculation

            // Step 4: Find the maximum height to the right of the current bar
            int rightMax = 0; // Initialize the right max height to 0
            
            while (j < n) {
                rightMax = Math.max(rightMax, height[j]); // Update rightMax as the maximum between rightMax and height[j]
                j++; // Move to the next bar on the right
            }
            
            // Step 5: Calculate the water trapped above the current bar
            // Water trapped at the current bar is the minimum of leftMax and rightMax minus the height of the current bar
            waterTrapped += Math.min(leftMax, rightMax) - height[i];
        }

        // Return the total trapped water
        return waterTrapped;
    }
    */
    
    /*
    // 2nd Approach: Better Solution - Time Complexity = O(n), Space Complexity = O(n)
    public int trap(int[] height) {
    
        // Get the length of the height array
        int n = height.length; 

        // Edge case: if there are fewer than 3 bars, no water can be trapped
        if (n < 3) {
            return 0;
        }

        // Step 1: Initialize arrays to store left and right max heights for each position
        int prefix[] = new int[n]; // prefix[i] stores the maximum height from the left up to index i
        int suffix[] = new int[n]; // suffix[i] stores the maximum height from the right up to index i

        // Step 2: Compute the prefix maximum heights
        prefix[0] = height[0]; // First element's prefix max is the element itself
        for (int i = 1; i < n; i++) {
            // prefix[i] is the maximum of the previous prefix max or the current height
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        // Step 3: Compute the suffix maximum heights
        suffix[n - 1] = height[n - 1]; // Last element's suffix max is the element itself
        for (int i = n - 2; i >= 0; i--) {
            // suffix[i] is the maximum of the next suffix max or the current height
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        // Step 4: Calculate the total water trapped
        int waterTrapped = 0; // Initialize the water trapped counter
       
        for (int i = 0; i < n; i++) {
            // Water trapped at index i is the minimum of prefix and suffix maxes minus the height
            waterTrapped += Math.min(prefix[i], suffix[i]) - height[i];
        }

        // Return the total water trapped
        return waterTrapped;
    }
    */

    
    // 3rd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(1)
    public int trap(int[] height) {
        
        // Get the length of the height array
        int n = height.length; 

        // If there are fewer than 3 bars, no water can be trapped
        if (n < 3) {
            return 0;
        }

        // Initialize two pointers for the left and right ends of the array
        int left = 0, right = n - 1;

        // Initialize variables to keep track of the maximum heights on both sides
        int maxLeft = 0, maxRight = 0;

        // Initialize the result to store total water trapped
        int res = 0;

        // Traverse the array using two pointers
        while (left <= right) {
            // Compare the heights at left and right pointers
            if (height[left] <= height[right]) {
                // If current height at left is less than or equal to the height at right, process the left side
                if (height[left] >= maxLeft) {
                    // Update maxLeft if current height is greater
                    maxLeft = height[left];
                } else {
                    // Calculate trapped water at the current left position
                    res += maxLeft - height[left];
                }

                // Move left pointer to the right
                left++; 
            } else {
                // If height at right is less than height at left, process the right side
                if (height[right] >= maxRight) {
                    // Update maxRight if current height is greater
                    maxRight = height[right];
                } else {
                    // Calculate trapped water at the current right position
                    res += maxRight - height[right];
                }

                // Move right pointer to the left
                right--; 
            }
        }
        
        // Return the total trapped water
        return res; 
    }
}
