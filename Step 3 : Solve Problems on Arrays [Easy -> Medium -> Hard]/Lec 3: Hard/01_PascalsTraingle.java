// Question Link: https://leetcode.com/problems/pascals-triangle/description/


class Solution {
    /*    
    // Helper method to calculate nCr (binomial coefficient)
    public static int nCr(int n, int r) {
        long res = 1; // Initialize result as 1 (as nC0 is 1)

        // Loop to calculate the value of nCr using the formula:
        // nCr = n! / (r! * (n - r)!)
        for (int i = 0; i < r; i++) {
            res = res * (n - i); // Multiply with (n - i)
            res = res / (i + 1); // Divide by (i + 1) to maintain the binomial coefficient formula
        }

        return (int) res; // Return the computed value as an integer
    }

    // 1st Approach: Brute Force Approach - Time Complexity = O(numRows^3), Space Complexity = O(numRows^2)
    public List<List<Integer>> generate(int numRows) {
        // Initialize the final result list
        List<List<Integer>> ans = new ArrayList<>(); 

        // Loop through each row from 0 to numRows - 1
        for (int row = 0; row < numRows; row++) {
            ArrayList<Integer> tempList = new ArrayList<>(); // Temporary list to store the current row

            // Loop through each element in the current row
            for (int col = 0; col <= row; col++) {
                tempList.add(nCr(row, col)); // Add the value of nCr(row, col) to the current row
            }

            ans.add(tempList); // Add the current row to the final result list
        }

        return ans; // Return the final list containing the Pascal's triangle
    }
    */


    // Helper method to generate a specific row of Pascal's Triangle
    public static List<Integer> generateRow(int row) {
        long ans = 1; // Initialize the first element as 1
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // Add the first element of the row

        // Calculate the rest of the elements
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col); // Update the numerator
            ans = ans / col;         // Update the denominator

            ansRow.add((int) ans);   // Add the computed element to the row
        }

        return ansRow; // Return the generated row
    }

    // 2nd Approach: Optimal Approach - Time Complexity = O(numRows^2), Space Complexity = O(numRows^2)
    public static List<List<Integer>> generate(int numRows) {
        // List to store final result
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's Triangle row by row
        for (int row = 1; row <= numRows; row++) {
            ans.add(generateRow(row));
        }
        
        return ans; // Return the complete Pascal's Triangle
    }
}
