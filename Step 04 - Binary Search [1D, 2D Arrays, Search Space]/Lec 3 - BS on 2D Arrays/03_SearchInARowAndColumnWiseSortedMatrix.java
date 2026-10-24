// Question Link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n * m), Space Complexity = O(1)
    public boolean searchMatrix(int[][] matrix, int target) { 
        
        // Iterate over each row of the matrix
        for (int i = 0; i < matrix.length; i++) { 
            
            // Iterate over each element in the current row
            for (int j = 0; j < matrix[i].length; j++) { 
                
                // Check if the current element is equal to the target
                if (matrix[i][j] == target) { 
                    return true; // If found, return true
                }
            }
        }

        // If the target is not found after checking all elements, return false
        return false; 
    }
    */

    /*
    public static boolean binarySearch(int[] arr, int target) {
        // Initialize the lower bound of the search range
        int low = 0; 

        // Initialize the upper bound of the search range
        int high = arr.length - 1; 

        // Continue searching while the range is valid
        while (low <= high) { 

            // Find the middle index of the current range
            int mid = (low + high) / 2; 

            // Check if the middle element is the target
            if (arr[mid] == target) { 
                return true; // If found, return true
            } else if (target > arr[mid]) { // If the target is greater than the middle element
                low = mid + 1; // Narrow the search range to the right half
            } else { // If the target is less than the middle element
                high = mid - 1; // Narrow the search range to the left half
            }
        }

        // Return false if the target is not found after the search range is exhausted
        return false; 
    }

    // 2nd Approach: Better Approach (Using Binary Search) - Time Complexity = O(n * log(m)), Space Complexity = O(1)
    public boolean searchMatrix(int[][] matrix, int target) { 
        
        // Iterate over each row of the matrix
        for (int i = 0; i < matrix.length; i++) {

            // Get the number of columns in the current row 
            int m = matrix[i].length; 
            
            // search for element
            if (binarySearch(matrix[i], target)) {
                return  true;
            }
        }

        // If the target is not found in any row, return false
        return false; 
    }
    */

    // 3rd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(m * n)), Space Complexity = O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        // Starting row index
        int row = 0;                      

        // Starting column index (last column)
        int col = matrix[0].length - 1;   

        // Loop until out of matrix bounds
        while (row < matrix.length && col >= 0) {
            
            // Check if the current element is the target
            if (matrix[row][col] == target) {
                return true;  // Target found
            } 
            // Move left if the current element is greater than the target
            else if (matrix[row][col] > target) {
                col--;
            } 
            // Move down if the current element is less than the target
            else {
                row++;
            }
        }

        // Target not found
        return false;
    }
}
