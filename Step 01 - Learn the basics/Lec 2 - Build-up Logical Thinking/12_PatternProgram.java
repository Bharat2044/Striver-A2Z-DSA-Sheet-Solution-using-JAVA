// Question Link: https://www.naukri.com/code360/problems/number-crown_6581894?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems&leftPanelTabValue=PROBLEM


public class Solution {
    public static void numberCrown(int n) {
        
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            for (int s = 1; s <= 2 * n - 2 * i; s++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print((i - j + 1) + " ");
            }

            System.out.println();
        }
    }
}
