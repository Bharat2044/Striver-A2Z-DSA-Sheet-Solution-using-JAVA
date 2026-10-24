// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using 2 Iterations) - Time Complexity = O(n), Space Complexity = O(1)
    public int maxProfit(int[] prices) {
        // Initialize maxProfit to 0. This will store the maximum profit found.
        int maxProfit = 0;

        // Outer loop: Iterate over each possible buy day.
        for (int i = 0; i < prices.length - 1; i++) {

            // Inner loop: Iterate over each possible sell day after the current buy day.
            for (int j = i + 1; j < prices.length; j++) {
                
                // Check if selling on day j is profitable compared to buying on day i.
                if (prices[j] > prices[i]) {
                    // Calculate the profit from buying on day i and selling on day j.
                    int profit = prices[j] - prices[i];
                   
                    // Update maxProfit if this profit is greater than the current maxProfit.
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }

        // Return the maximum profit found.
        return maxProfit;
    }
    */


    /*
    // 2nd Approach: Better Loop (Using Extra Space) - Time Complexity = O(n), Space Complexity = O(n)
    public int maxProfit(int[] prices) {
        
        // Initialize minPrice to the largest possible integer value
        // This will help in finding the minimum price in the first pass
        int minPrice = Integer.MAX_VALUE;

        // Create an array to store the minimum price up to each day
        int[] minPrices = new int[prices.length];

        // First pass: Calculate minimum price up to each day
        for (int i = 0; i < prices.length; i++) {
            // Update minPrice if the current price is lower than minPrice
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // Store the minimum price found up to the current day in minPrices
            minPrices[i] = minPrice;
        }

        // Initialize maxProfit to 0
        // This will store the maximum profit that can be achieved
        int maxProfit = 0;

        // Second pass: Calculate the maximum profit using the minPrices array
        for (int i = 0; i < prices.length; i++) {
            // Calculate the profit if we sell at the current day's price
            int profit = prices[i] - minPrices[i];

            // Update maxProfit if the calculated profit is greater than the current maxProfit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }
    */


    // 3rd Approach: Optimal Loop (Using 1 Loop) - Time Complexity = O(n), Space Complexity = O(1)
    
    public int maxProfit(int[] prices) {
        // Initialize the minimum price to a large value
        int minPrice = Integer.MAX_VALUE;

        // Initialize maxProfit to 0
        int maxProfit = 0;

        // Iterate over each price in the array using a for loop
        for (int i = 0; i < prices.length; i++) {
            /*
            // Update minPrice to the smallest value seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) { // Calculate the potential profit and update maxProfit if it's greater
                maxProfit = prices[i] - minPrice;
            }
            */

            // Update minPrice to the smallest value seen so far
            minPrice = Math.min(minPrice, prices[i]);
            
            // Calculate the potential profit and update maxProfit if it's greater
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        // Return the maximum profit found
        return maxProfit;
    }
}
