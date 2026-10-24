// Question Link: https://www.naukri.com/code360/problems/n-2-forest_6570178?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {
    public static void nForest(int n) {

        // Iterate over each row
        for (int i = 1; i <= n; i++) {
            
            // Print 'i' number of "* " for the current row
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Move to the next line after printing all asterisks in the current row
            System.out.println();
        }
    }
}
