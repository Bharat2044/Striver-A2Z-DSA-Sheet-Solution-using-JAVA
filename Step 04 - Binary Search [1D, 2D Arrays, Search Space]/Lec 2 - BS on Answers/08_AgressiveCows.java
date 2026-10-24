// Question Link: https://www.spoj.com/problems/AGGRCOW/
// Question Link: https://www.naukri.com/code360/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse


import java.util.*;

public class Solution {

    // Helper method to check if we can place cows with at least 'dist' distance apart
    public static boolean canWePlace(int[] stalls, int dist, int cows) {

        // Start by placing the first cow at the first stall
        int cntCows = 1; 

        // Track the position of the last placed cow
        int last = stalls[0]; 

        // Iterate through the stalls starting from the second one
        for (int i = 1; i < stalls.length; i++) {
            
            // If the current stall is at least 'dist' distance from the last placed cow
            if (stalls[i] - last >= dist) {
                cntCows++; // Place the next cow at this stall
                last = stalls[i]; // Update the position of the last placed cow
            }

            // If we have placed all the cows, return true
            if (cntCows >= cows) {
                return true;
            }
        }

        // Return false if we cannot place all cows with at least 'dist' distance apart
        return false;
    }

    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * log(n)) + O(n * (max(stalls[]) - min(stalls[]))), Space Complexity = O(1)
    public static int aggressiveCows(int[] stalls, int k) {

        // Sort the stalls to consider the distance between them in increasing order
        Arrays.sort(stalls);

        // Maximum possible distance between the first and last stall
        int limit = stalls[stalls.length - 1] - stalls[0]; 
        
        // Iterate over all possible minimum distances starting from 1 up to the maximum distance
        for (int i = 1; i <= limit; i++) {
            
            // If we can't place the cows with the current minimum distance 'i', return (i - 1)
            if (!canWePlace(stalls, i, k)) {
                return (i - 1);
            }
        }

        // If all distances are valid, return the maximum possible distance
        return limit;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(n * log(n)) + O(n * log(max(stalls[]) - min(stalls[]))), Space Complexity = O(1)
    public static int aggressiveCows(int[] stalls, int k) {
        
        // Sort the stalls array to consider distances in increasing order
        Arrays.sort(stalls);

        // Initialize the search range for the minimum distance
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];

        // Perform binary search to find the maximum minimum distance
        while (low <= high) {

            // Calculate the middle distance
            int mid = (low + high) / 2; 
            
            // Check if it's possible to place cows with at least 'mid' distance apart
            if (canWePlace(stalls, mid, k)) {
                // If possible, move to the right half to find a larger minimum distance
                low = mid + 1;
            } else {
                // If not possible, move to the left half to reduce the minimum distance
                high = mid - 1;
            }
        }

        // 'high' will be the maximum minimum distance that allows placing all cows
        return high;
    }
}

