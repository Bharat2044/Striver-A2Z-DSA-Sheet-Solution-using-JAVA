// Question Link: https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


import java.util.*;

public class Solution {

    // Method to count the number of painters required to paint all boards within a given maximum time
    public static int countPainters(ArrayList<Integer> boards, int time) {
        
        // Start with one painter
        int painters = 1; 

        // Initialize the sum of the current painter's work
        long boardsPainter = 0; 

        // Iterate through each board
        for (int i = 0; i < boards.size(); i++) {
            // If the current painter can paint this board without exceeding the time limit
            if (boardsPainter + boards.get(i) <= time) {
                boardsPainter += boards.get(i); // Assign the board to the current painter
            } else {
                // If it exceeds, assign the board to the next painter
                painters++; // Increase the painter count
                boardsPainter = boards.get(i); // Start a new workload for the next painter
            }
        }

        // Return the number of painters required
        return painters; 
    }

    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * (sum(arr[])-max(arr[])+1)), Space Complexity = O(1)
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
       
        // Set low to the length of the longest board (minimum possible max time)
        int low = Collections.max(boards);

        // Set high to the sum of all board lengths (maximum possible max time)
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        // Iterate over all possible maximum times from low to high
        for (int time = low; time <= high; time++) {
            // Check if the number of painters required with this maximum time is less than or equal to k
            if (countPainters(boards, time) <= k) {
                // If the condition is met, return this maximum time as the solution
                return time;
            }
        }

        // If no exact match is found, return the minimum possible maximum time
        return low;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(n * log(sum(arr[])-max(arr[])+1)), Space Complexity = O(1)
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        // The minimum possible time is the time to paint the largest board
        int low = Collections.max(boards);

        // The maximum possible time is the sum of all board lengths (one painter paints all)
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        // Binary search to find the minimum time that allows painting with exactly k painters
        while (low < high) {

            // Calculate the midpoint of the current range
            int mid = low + (high - low) / 2;

            // Determine the number of painters needed if the max time per painter is mid
            if (countPainters(boards, mid) <= k) {
                // If k or fewer painters are needed, search in the lower half (mid might be too high)
                high = mid;
            } else {
                // If more than k painters are needed, search in the upper half (mid is too low)
                low = mid + 1;
            }
        }

        // Return the minimum time found that satisfies the condition
        return low;
    }
}
