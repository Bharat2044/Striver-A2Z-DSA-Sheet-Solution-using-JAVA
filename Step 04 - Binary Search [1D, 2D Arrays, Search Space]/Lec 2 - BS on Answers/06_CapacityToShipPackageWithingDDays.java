// Question Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/


class Solution {

    // Helper function to calculate the number of days needed to ship all packages with a given capacity
    public int findDays(int[] weights, int capacity) {
        // Initialize the number of days required to 1
        int days = 1; 

        // Initialize the current load on the ship to 0
        int currentLoad = 0; 
        
        // Loop through each weight in the array
        for (int weight : weights) {
            // Check if adding the current package exceeds the ship's capacity
            if (currentLoad + weight > capacity) {
                days++; // If it exceeds, increment the day counter (move to the next day)
                currentLoad = weight; // Start the load for the new day with the current package
            } else {
                currentLoad += weight; // Otherwise, add the package to the current day's load
            }
        }

        // Return the total number of days needed with the given capacity
        return days; 
    }

    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * (sum(weights[]) - max(weights[]) + 1)), Space Complexity = O(1)
    public int shipWithinDays(int[] weights, int days) {
        // Initialize the maximum weight in the array to 0
        int maxWeight = 0; 

        // Initialize the total weight of all packages to 0
        int totalWeight = 0; 

        // Loop through the weights array to find the maximum and total weights
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight); // Find the maximum weight in the array
            totalWeight += weight; // Calculate the total weight of all packages
        }

        // Brute-force search from the maximum weight to the total weight
        for (int capacity = maxWeight; capacity <= totalWeight; capacity++) {
            // Check if the current capacity can ship all packages within the given days
            if (findDays(weights, capacity) <= days) {
                return capacity; // If it can, return the current capacity as the result
            }
        }

         // Return -1 if no valid capacity is found, though the problem guarantees an answer
        return -1;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity =  O(n * log(sum(weights[]) - max(weights[]) + 1)), Space Complexity = O(1)
    public int shipWithinDays(int[] weights, int days) {
        // Initialize the lower bound as the minimum possible ship capacity
        int low = Integer.MIN_VALUE;  

        // Initialize the upper bound as 0, will store the total weight of all packages
        int high = 0;  

        // Loop through the weights array to calculate the bounds for binary search
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];  // Calculate the total weight of all packages (upper bound)
            low = Math.max(low, weights[i]);  // Find the maximum weight in the array (lower bound)
        }

        // Perform binary search between the lower and upper bounds
        while (low <= high) {
            // Calculate the middle point (potential capacity)
            int mid = (low + high) / 2;  

            // Calculate the number of days required for the current capacity
            int numberOfDays = findDays(weights, mid);  

            if (numberOfDays <= days) {
                // If the number of days is within the limit, try a smaller capacity (eliminate the right half)
                high = mid - 1;
            } else {
                // If the number of days exceeds the limit, try a larger capacity (eliminate the left half)
                low = mid + 1;
            }
        }

        // The minimum capacity required to ship all packages within the given days
        return low;  
    }
}
