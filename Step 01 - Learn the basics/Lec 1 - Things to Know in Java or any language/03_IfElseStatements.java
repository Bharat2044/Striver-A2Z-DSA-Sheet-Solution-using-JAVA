// Question Link: https://www.geeksforgeeks.org/problems/java-if-else-decision-making0924/0?category%255B%255D=Java&difficulty%255B%255D=-2&page=1&query=category%255B%255DJavadifficulty%255B%255D-2page1category%255B%255DJava



class Solution {
    /*
    // 1st Approach: Using If-Else - TC = O(1), SC = O(1)
    public static String compareNM(int n, int m) {
        // If n is greater than m, return "greater"
        if (n > m) {
            return "greater";
        } else if (n < m) { // If n is less than m, return "lesser"
            return "lesser";
        } else { // If n is equal to m, return "equal"
            return "equal";
        }
    }
    */
    
    // 2nd Approach: Using Ternary Operator - TC = O(1), SC = O(1)
    public static String compareNM(int n, int m) {
        
        return (n > m) ? "greater" : (n < m) ? "lesser" : "equal";
    }
}
