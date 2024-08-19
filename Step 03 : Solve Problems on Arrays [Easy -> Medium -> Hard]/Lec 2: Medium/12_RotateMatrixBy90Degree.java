// Question Link: https://leetcode.com/problems/rotate-image/description/


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Extra Space) - Time Complexity = O(n^2), Space Complexity = O(n^2)
    public void rotate(int[][] matrix) {
        
        // Get the length of the matrix (n x n)
        int n = matrix.length;
        
        // Allocate a temporary matrix to store the rotated version
        int[][] temp = new int[n][n]; 

        // Traverse the original 'matrix' and place its rotated values into 'temp'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[n - j - 1][i];
            }
        }

        // Copy the rotated values from 'temp' back to 'matrix'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
    */

    // 2nd Approach: Optimal Approach (Using Transpose the Matrix) - Time Complexity = O(n^2), Space Complexity = O()
    public void rotate(int[][] matrix) {
        
        // Get the length of the matrix (n x n)
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        // Transposing means converting rows to columns and columns to rows.
        // Iterate through the upper triangular part of the matrix.
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // Reversing each row will complete the 90-degree rotation.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                
                // Swap elements to reverse the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}


