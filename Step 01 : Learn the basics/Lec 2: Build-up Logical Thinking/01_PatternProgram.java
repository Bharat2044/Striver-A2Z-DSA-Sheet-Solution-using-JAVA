// Question Link: https://www.naukri.com/code360/problems/n-forest_6570177?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {
    public static void nForest(int n) {
        // Iterate over each row
        for (int i = 1; i <= n; i++) {
            
            // Iterate over each column in the current row
            for (int j = 1; j <= n; j++) {
                // Print an star(*) followed by a space
                System.out.print("* ");
            }

            // Move to the next line after printing all columns in the current row
            System.out.println();
        }
    }
}
