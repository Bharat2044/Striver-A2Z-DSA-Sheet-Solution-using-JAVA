// Question Link: https://leetcode.com/problems/maximal-rectangle/description/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O((rows * cols)^2), Space Complexity = O(1)
    public int maximalRectangle(char[][] matrix) {
    
        // Check if the matrix is empty, return 0 if true
        if (matrix.length == 0) {
            return 0;
        }
        
        // Get the number of rows and columns in the matrix
        int rows = matrix.length, cols = matrix[0].length;
        
        // Initialize a variable to store the maximum area found
        int maxArea = 0;

        // Iterate over each cell in the matrix to use as the potential top-left corner of a rectangle
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                
                // Only proceed if the current cell has '1'
                if (matrix[i][j] == '1') {
                    
                    // Initialize the maximum possible width for the rectangle at this cell
                    int width = cols;

                    // Attempt to expand the rectangle downwards row by row
                    for (int k = i; k < rows && matrix[k][j] == '1'; k++) {
                        
                        // Initialize the current width to zero for this row
                        int currentWidth = 0;

                        // Expand the width as long as we find consecutive '1's in the current row
                        // and stay within the column bounds
                        while (j + currentWidth < cols && matrix[k][j + currentWidth] == '1') {
                            currentWidth++;
                        }

                        // Update the width to the minimum width found so far (to maintain a rectangle)
                        width = Math.min(width, currentWidth);

                        // Calculate the area of the rectangle formed up to row `k` and update `maxArea` if it's larger
                        int area = width * (k - i + 1);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        // Return the largest rectangle area found
        return maxArea;
    }
    */
    

    // Helper function to calculate the largest rectangle area in a histogram using a stack
    private int largestRectangleArea(int[] heights) {
        // Initialize the maximum area for this histogram
        int maxArea = 0;

        // Stack to store the indices of the histogram bars in increasing height order
        Stack<Integer> stack = new Stack<>();

        // Iterate through each bar in the histogram, including an extra 0-height bar at the end
        for (int i = 0; i <= heights.length; i++) {
            // Assign the current height, or 0 if we're past the last bar to help clear the stack
            int h = (i == heights.length) ? 0 : heights[i];

            // Process bars in the stack as long as the current bar is shorter than the stack's top bar
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                // Pop the height of the bar at the top of the stack
                int height = heights[stack.pop()];

                // Determine the width of the rectangle with the popped height as the smallest bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // Calculate the area for this rectangle and update maxArea if it's larger
                maxArea = Math.max(maxArea, height * width);
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        // Return the largest rectangle area found in this histogram
        return maxArea;
    }
    
    // 2nd Approach: Optimal Solution - Time Complexity = O(rows * cols), Space Complexity = O(cols)
    public int maximalRectangle(char[][] matrix) {
        
        // Check if the matrix is empty; if true, return 0 as no rectangles are possible
        if (matrix.length == 0) {
            return 0;
        }

        // Get the number of rows and columns in the matrix
        int rows = matrix.length, cols = matrix[0].length;

        // Initialize an array to store the height of consecutive '1's for each column up to the current row
        int[] heights = new int[cols];

        // Variable to keep track of the maximum rectangle area found
        int maxArea = 0;

        // Process each row in the matrix
        for (int i = 0; i < rows; i++) {
            // Update the heights array for the current row
            for (int j = 0; j < cols; j++) {
                // If the current cell is '1', increment the height for that column
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }

            // Calculate the largest rectangle area for the current row's histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        // Return the maximum rectangle area found
        return maxArea;
    }
}
