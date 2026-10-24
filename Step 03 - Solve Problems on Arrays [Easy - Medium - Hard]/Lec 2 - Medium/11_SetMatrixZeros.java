// Question Link: https://leetcode.com/problems/set-matrix-zeroes/


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * m * (n + m)), Space Complexity = O(n * m)
    public void setZeroes(int[][] matrix) {
        // Get the number of rows and columns
        int n = matrix.length;
        int m = matrix[0].length;

        // Create a copy of the original matrix
        int[][] temp = new int[n][m];
        
        // copy the marix element into the temp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        // Iterate through the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If an element in the original matrix is zero
                if (temp[i][j] == 0) {
                    // Set the entire row to zero
                    for (int k = 0; k < m; k++) {
                        matrix[i][k] = 0;
                    }

                    // Set the entire column to zero
                    for (int k = 0; k < n; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
    */

    /*
    // 2nd Approach: Brute Force Approach - Time Complexity = O(n * m * (n + m)), Space Complexity = O(1)
    public void setZeroes(int[][] matrix) {
        // Get the number of rows and columns
        int n = matrix.length;
        int m = matrix[0].length;

        // Step 1: Mark rows and columns that need to be set to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If an element is zero, mark its row and column for setting to zero
                if (matrix[i][j] == 0) {
                    // Mark the row
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = Integer.MAX_VALUE;
                        }
                    }

                    // Mark the column
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }

        // Step 2: Set the marked elements to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    */


    /*
    // 3rd Approach: Better Approach - Time Complexity = O(n * m), Space Complexity = O(n + m)
    public void setZeroes(int[][] matrix) {
    
        // Get the number of rows in the matrix
        int n = matrix.length;

        // Get the number of columns in the matrix
        int m = matrix[0].length;

        // Create a boolean array to mark the rows that need to be set to zero
        boolean[] row = new boolean[n]; 

        // Create a boolean array to mark the columns that need to be set to zero
        boolean[] col = new boolean[m];  

        // Iterate through the matrix to find the zero elements
        // This loop will mark which rows and columns need to be set to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If an element is zero, mark its row and column
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Iterate through the matrix again to set the appropriate elements to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If the row or column is marked, set the element to zero
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    */

    // 4th Approach: Optimal Approach - Time Complexity = O(n * m), Space Complexity = O(1)
    public void setZeroes(int[][] matrix) {
        // Get the number of rows and columns
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Variables to track if the first row and first column need to be zeroed
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // Determine if the first row needs to be zeroed
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Determine if the first column needs to be zeroed
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Use the first row and first column to mark rows and columns that need to be zeroed
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                if (matrix[i][j] == 0) {
                    // Mark the corresponding row and column in the first row and first column
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Zero out marked rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                
                // If the row or column is marked, set the element to zero
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
