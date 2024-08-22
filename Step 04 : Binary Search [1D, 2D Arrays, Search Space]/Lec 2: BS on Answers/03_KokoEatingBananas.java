// Question Link: https://leetcode.com/problems/koko-eating-bananas/description/


class Solution {
    // Method to find the maximum number of bananas in any single pile.
    private int findMaxPile(int[] piles) {
        // Initialize maxPile with the first pile's size.
        int maxPile = piles[0]; 

        // Iterate through the rest of the piles to find the maximum size.
        for (int i = 1; i < piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]); // Update maxPile if current pile is larger.
        }
        
        // Return the maximum pile size found.
        return maxPile; 
    }

    // Method to calculate the total hours required to eat all piles with a given speed k.
    private int calculateHoursSpent(int[] piles, int k) {
        // Initialize the total hours spent.
        int hoursSpent = 0; 

        // Iterate through each pile to calculate the hours needed at speed k.
        for (int pile : piles) {
            // Calculate the hours needed for the current pile and add to the total.
            hoursSpent += Math.ceil((double)(pile) / (double)(k));
        }

        // Return the total hours spent at speed k.
        return hoursSpent; 
    }

    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * max(piles[])), Space Complexity = O(1)
    public int minEatingSpeed(int[] piles, int h) {
        // Find the maximum pile size to limit the search space.
        int maxPile = findMaxPile(piles); 

        // Check every possible speed from 1 to maxPile.
        for (int i = 1; i <= maxPile; i++) {
            // Calculate the hours needed at speed i.
            int hoursSpent = calculateHoursSpent(piles, i); 
            
            // If the total hours spent is within the limit h, return the current speed i.
            if (hoursSpent <= h) {
                return i;
            }
        }
        
        // If no solution is found (which theoretically should not happen), return maxPile.
        return maxPile;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(n * log(max(piles[]))), Space Complexity = O(1)
    public int minEatingSpeed(int[] piles, int h) {
        // Minimum possible eating speed
        int left = 1; 

        // Maximum possible eating speed (size of the largest pile)
        int right = findMaxPile(piles); 

        // Binary search for the minimum valid eating speed
        while (left <= right) {
            // Calculate Midpoint speed
            int mid = left + (right - left) / 2; 
            
            // Calculate hours needed at speed mid
            int hoursSpent = calculateHoursSpent(piles, mid); 
            
            if (hoursSpent <= h) {
                right = mid - 1; // Try to find a smaller valid speed
            } else {
                left = mid + 1; // Increase speed since mid is too slow
            }
        }

        // The minimum speed at which Koko can finish within h hours
        return left; 
    }
}
