// Question Link: https://www.naukri.com/code360/problems/alpha-hill_6581921?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {
    public static void alphaHill(int n) {

        for (int i = 1; i <= n; i++) {

            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {

                if (i >= j) {
                    System.out.print((char) ('A' - 1 + j) + " ");
                } else {
                    System.out.print((char) ('A' - 1 + (2 * i - j)) + " ");
                }
            }

            System.out.println();
        }
    }
}
