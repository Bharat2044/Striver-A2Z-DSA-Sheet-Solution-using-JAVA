// Question Link: https://leetcode.com/problems/spiral-matrix/description/


class Solution {

    // Time Complexity = O(n * m), Space Complexity = O(n * m)
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // For storing matrix result in spiral manner
        List<Integer> result = new ArrayList<>();

        // if matrix is null or empty, directly return result
        if(matrix == null || matrix.length == 0) {
            return result;
        }

        int n = matrix.length;    // number of rows
        int m = matrix[0].length; // number of columns

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary left

            // Traverse from right to left along the bottom row, if there are remaining rows
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }

                bottom--; // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left column, if there are remaining columns
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }

                left++; // Move the left boundary right
            }
        }

        return result;
    }
}
