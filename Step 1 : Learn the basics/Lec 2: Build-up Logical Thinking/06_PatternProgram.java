// Question Link: https://www.naukri.com/code360/problems/reverse-number-triangle_6581889?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {
    public static void nNumberTriangle(int n) {
        
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
