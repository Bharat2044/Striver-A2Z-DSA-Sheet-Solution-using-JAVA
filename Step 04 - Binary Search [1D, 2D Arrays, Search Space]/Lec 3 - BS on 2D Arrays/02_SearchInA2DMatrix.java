// Question Link: https://leetcode.com/problems/search-a-2d-matrix/description/


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
            
            // Check if the target is within the range of the current row
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target); // Use binary search on the current row
            }
        }

        // If the target is not found in any row, return false
        return false; 
    }
    */

    // 3rd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(m * n)), Space Complexity = O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows in the matrix
        int m = matrix.length; 

        // Get the number of columns in the matrix
        int n = matrix[0].length;  

        // Initialize the start index of the conceptual flattened array
        int low = 0; 

        // Initialize the end index of the conceptual flattened array
        int high = m * n - 1; 

        // Perform binary search on the flattened matrix
        while (low <= high) {
            // Calculate the middle index of the current search range
            int mid = low + (high - low) / 2; 

            // Convert the middle index to corresponding 2D matrix indices
            int midValue = matrix[mid / n][mid % n]; 

            // Check if the middle value is equal to the target
            if (midValue == target) {
                return true; // Target found, return true
            } else if (midValue < target) {
                // If the middle value is less than the target, narrow the search to the right half
                low = mid + 1; 
            } else {
                // If the middle value is greater than the target, narrow the search to the left half
                high = mid - 1; 
            }
        }

        // If the target is not found after completing the search, return false
        return false; 
    }
}
