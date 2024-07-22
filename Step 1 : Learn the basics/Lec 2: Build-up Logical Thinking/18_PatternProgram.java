// Question Link: https://www.naukri.com/code360/problems/alpha-triangle_6581429?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_patternproblems


public class Solution {
    public static void alphaTriangle(int n) {
        
        for (int i = 1; i <= n; i++) {
        
            for (int j = 1; j <= i; j++) {
              
                System.out.print((char)('A' + n - j) + " ");
            }
            
            System.out.println();
        }
    }
}
