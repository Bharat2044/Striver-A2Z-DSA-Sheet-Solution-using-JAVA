// Question Link: https://leetcode.com/problems/find-a-peak-element-ii/description/


class Solution {

    public int getMaxElementRowIndex(int[][] matrix, int column) {
        // Initialize max to the smallest possible integer value
        int maxElement = Integer.MIN_VALUE; 

        // Variable to store the row index of the maximum element
        int maxRowIndex = -1; 

        // Iterate through each row in the specified column to find the maximum element
        for (int row = 0; row < matrix.length; row++) {

            // If the current element is greater than the current max, update max and maxRowIndex
            if (matrix[row][column] > maxElement) {
                maxElement = matrix[row][column];
                maxRowIndex = row;
            }
        }

        // Return the row index of the maximum element in the column
        return maxRowIndex; 
    }

    // Time Complexity = O(m * log(n)), Space Complexity = O(1)
    public int[] findPeakGrid(int[][] matrix) {
         // Start column index
        int low = 0;

        // End column index
        int high = matrix[0].length - 1; 

        // Binary search on columns to find a peak element
        while (low <= high) {

            // Calculate the mid column index
            int midColumn = (low + high) / 2; 
            
            // Find the row index of the maximum element in the mid column
            int peakRow = getMaxElementRowIndex(matrix, midColumn);
            
            // Get left and right neighbors of the mid column element
            int leftNeighbor = midColumn - 1 >= 0 ? matrix[peakRow][midColumn - 1] : -1;

            int rightNeighbor = midColumn + 1 < matrix[0].length ? matrix[peakRow][midColumn + 1] : -1;
            
            // Check if the mid column element is a peak
            if (matrix[peakRow][midColumn] > leftNeighbor && matrix[peakRow][midColumn] > rightNeighbor) {
                return new int[]{peakRow, midColumn}; // Return the position of the peak element
            } 
            // If the left neighbor is greater, search the left half
            else if (matrix[peakRow][midColumn] < leftNeighbor) {
                high = midColumn - 1;
            } 
            // If the right neighbor is greater, search the right half
            else {
                low = midColumn + 1;
            }
        }

        // Return [-1, -1] if no peak is found (shouldn't happen in a valid matrix)
        return new int[]{-1, -1}; 
    }
}
