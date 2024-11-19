// Question Link: https://leetcode.com/problems/online-stock-span/description/


class StockSpanner {
    /*
    // List to store the prices of each day
    private List<Integer> prices;

    // Constructor to initialize the list
    public StockSpanner() {
        prices = new ArrayList<>();
    }

    // 1st Approach: Brute Force Solution - Time Complexity = O(n^2), Space Complexity = O(n)
    public int next(int price) {
        // Add the current day's price to the list of prices
        prices.add(price);
        
        // Initialize span to 1 (the minimum span, as the current day always counts as itself)
        int span = 1;

        // Traverse the list backward from the second-last element
        // to count the number of consecutive days where price was <= the current price
        for (int i = prices.size() - 2; i >= 0; i--) {
            // Check if the price of the previous day is less than or equal to the current price
            if (prices.get(i) <= price) {
                // If it is, increment the span by 1
                span++;
            } else {
                // If we find a price greater than the current price, stop counting
                break;
            }
        }

        // Return the calculated span for the current price
        return span;
    }
    */

    
    // Stack to store pairs of prices and their spans
    private Stack<int[]> stack;

    // Constructor to initialize the stack
    public StockSpanner() {
        stack = new Stack<>();
    }

    // 2nd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(n)
    public int next(int price) {
        // Initialize the span for the current price to 1
        int span = 1;

        // Pop elements from the stack as long as the stack is not empty
        // and the price at the top of the stack is less than or equal to the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            
            // Accumulate the span by adding the span of the popped element
            span += stack.pop()[1];
        }

        // Push the current price and its calculated span onto the stack
        stack.push(new int[]{price, span});

        // Return the span for the current price
        return span;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
