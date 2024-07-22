// Question Link: https://www.naukri.com/code360/problems/symmetric-void_6581919?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {

    public static void symmetry(int n) {

        // upper part
        for (int i = 1; i <= n; i++) {

            // star
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print("* ");
            }

            // space
            for (int j = 1; j <= 2 * i - 2; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // lower part
        for (int i = n; i >= 1; i--) {

            // star
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print("* ");
            }

            // space
            for (int j = 1; j <= 2 * i - 2; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }

}
