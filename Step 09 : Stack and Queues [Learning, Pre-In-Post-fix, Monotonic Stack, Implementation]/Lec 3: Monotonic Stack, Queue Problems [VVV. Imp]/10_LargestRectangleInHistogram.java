// Question Link: https://leetcode.com/problems/largest-rectangle-in-histogram/description/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(n^2), Space Complexity = O(1)
    public int largestRectangleArea(int[] heights) {
        // Get the number of bars in the heightsgram
        int n = heights.length;

        // Initialize variable to store the maximum area found 
        int maxArea = 0; 

        // Outer loop to consider each bar as the starting point of a rectangle
        for (int i = 0; i < n; i++) {
            // Initialize minHeight to the maximum possible value
            int minHeight = Integer.MAX_VALUE; 

            // Inner loop to expand the rectangle from the starting bar to the right
            for (int j = i; j < n; j++) {
                // Update minHeight to the smallest height from i to j
                minHeight = Math.min(minHeight, heights[j]);
                
                // Calculate the area of the rectangle with height minHeight and width (j - i + 1)
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        
        // Return the maximum area found
        return maxArea; 
    }
    */

    /*
    // 2nd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(1)
    public int largestRectangleArea(int[] heights) {

        // Number of bars in the heightsgram
        int n = heights.length; 
        
        // Stack to store indices of heightsgram bars
        Stack<Integer> st = new Stack<>();
        
        // Arrays to store the index of the nearest smaller bar on the left and right for each bar
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];

        // Loop to fill leftSmall array
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the current height is smaller than the top of the stack
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop(); // Remove the larger element
            }

            // If stack is empty, no smaller element on the left; set leftSmall[i] to 0 (left boundary)
            if (st.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                // Set leftSmall[i] to index of nearest smaller element + 1 for rectangle width calculation
                leftSmall[i] = st.peek() + 1;
            }

            // Push the current index onto the stack
            st.push(i);
        }

        // Clear the stack for the rightSmall calculation
        while (!st.isEmpty()){
            st.pop();
        }

        // Loop to fill rightSmall array
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements while the current height is smaller than or equal to the top of the stack
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            // If stack is empty, no smaller element on the right; set rightSmall[i] to n - 1 (right boundary)
            if (st.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                // Set rightSmall[i] to index of the nearest smaller element - 1 for width calculation
                rightSmall[i] = st.peek() - 1;
            }

            // Push the current index onto the stack
            st.push(i);
        }

        // Variable to keep track of the maximum area found
        int maxA = 0;

        // Calculate the area for each bar as the height * width, updating maxA if a larger area is found
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }

        // Return the maximum area found
        return maxA; 
    }
    */

    // 3rd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(1)
    public int largestRectangleArea(int[] heights) {
        // Get the number of bars in the histogram
        int n = heights.length; 

        // Stack to hold indices of the histogram bars
        Stack<Integer> st = new Stack<>(); 

        // Initialize variable to keep track of the maximum area
        int maxA = 0; 

        // Iterate through all bars, including one extra iteration at the end to handle remaining bars
        for (int i = 0; i <= n; i++) {

            // Process bars in the stack until we find one shorter than the current bar
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.pop()]; // Height of the bar to calculate area

                // Calculate width of the rectangle formed by the popped height
                int width;
                
                if (st.empty()) {
                    // If stack is empty, width is from start (0) to current index i
                    width = i;
                } else {
                    // Width is the distance between the current index and the index of the next element in the stack
                    width = i - st.peek() - 1;
                }

                // Calculate area with the popped height and update maxA if this area is the largest so far
                maxA = Math.max(maxA, width * height);
            }

            // Push the current index onto the stack
            st.push(i);
        }

        // Return the maximum area found
        return maxA; 
    }
}
