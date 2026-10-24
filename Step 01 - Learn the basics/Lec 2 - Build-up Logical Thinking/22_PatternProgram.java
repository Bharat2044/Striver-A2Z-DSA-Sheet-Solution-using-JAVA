// Question Link: https://www.naukri.com/code360/problems/ninja-and-the-number-pattern-i_6581959?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {
    public static void getNumberPattern(int n) {

        for (int i = 0; i < 2 * n - 1; i++) {
            int currentNum = 0;

            for (int j = 0; j < 2 * n - 1; j++) {
                currentNum = Math.min(Math.min(i, j), Math.min(2 * n - i - 2, 2 * n - j - 2));

                System.out.print(n - currentNum);
            }

            System.out.println();
        }
    }
}
