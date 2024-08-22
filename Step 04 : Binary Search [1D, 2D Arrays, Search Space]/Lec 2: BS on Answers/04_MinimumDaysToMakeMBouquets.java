// Question Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/


class Solution {
    
    // Method to Checks if it is possible to make 'm' bouquets with 'k' adjacent flowers within 'day' days.
    public boolean possible(int[] bloomDay, int day, int m, int k) {
        // Tracks consecutive flowers that have bloomed
        int flowerCount = 0; 

        // Tracks the number of bouquets made
        int bouquetCount = 0; 

        // Iterate over each flower's bloom day
        for (int i = 0; i < bloomDay.length; i++) {

            // If flower has bloomed by the given day
            if (bloomDay[i] <= day) { 
                flowerCount++; // Increment the count of adjacent bloomed flowers
            } else {
                // Calculate how many bouquets can be made with the consecutive bloomed flowers
                bouquetCount += (flowerCount / k);

                flowerCount = 0; // Reset flower count for next sequence
            }
        }

        // Final check in case the last set of flowers were sufficient for additional bouquets
        bouquetCount += (flowerCount / k);

        // Return true if the number of bouquets meets or exceeds the required count
        return bouquetCount >= m;
    }
    
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * (max(bloomDay[]) - min(bloomDay[]) + 1)), Space Complexity = O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        // Calculate the total number of flowers needed to make 'm' bouquets
        long totalFlowersNeeded = (long) m * k;
        
        // If the total flowers needed exceeds the total flowers available, return -1 (impossible case)
        if (totalFlowersNeeded > bloomDay.length) {
            return -1;
        }
        
        // Initialize the minimum and maximum bloom days
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        // Find the minimum and maximum bloom days
        for (int i = 0; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        // Linear search for the minimum day where it's possible to make 'm' bouquets
        for (int i = minDay; i <= maxDay; i++) {
            if (possible(bloomDay, i, m, k)) {
                return i; // Return the first day where it is possible
            }
        }

        // Return -1 if no valid day is found (should not occur given prior checks)
        return -1;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(n * log(max(bloomDay[]) - min(bloomDay[]) + 1)), Space Complexity = O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        
        // Calculate the total number of flowers needed to make 'm' bouquets
        long totalFlowersNeeded = (long) m * k;
        
        // If the total flowers needed exceeds the total flowers available, return -1 (impossible case)
        if (totalFlowersNeeded > bloomDay.length) {
            return -1;
        }
        
        // Initialize the minimum and maximum bloom days
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        // Find the minimum and maximum bloom days
        for (int i = 0; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        // Binary search for the minimum day where it's possible to make 'm' bouquets
        int low = minDay;
        int high = maxDay;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If possible to make m bouquets by mid days, search in the lower half
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                // Otherwise, search in the upper half
                low = mid + 1;
            }
        }
        
        return low;
    }
}
