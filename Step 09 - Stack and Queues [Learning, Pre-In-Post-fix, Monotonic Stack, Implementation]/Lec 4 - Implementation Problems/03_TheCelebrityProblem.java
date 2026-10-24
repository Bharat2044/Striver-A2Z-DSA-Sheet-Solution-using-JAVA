// Question Link: https://leetcode.com/problems/find-the-celebrity/description/
// Question Link: https://www.geeksforgeeks.org/the-celebrity-problem/


// java program to find celebrity
import java.util.*;

public class GFG {

    // Function to check if person 'a' knows person 'b'
    static boolean knows(int a, int b, int[][] matrix) {
        return matrix[a][b] == 1;
    }

    // Returns -1 if celebrity is not present. If present,
    // returns id (value from 0 to n-1).
    static int findCelebrity(int n, int[][] matrix) {
        // the graph needs not be constructed
        // as the edges can be found by using knows function

        // degree array;
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        // query for all edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                // Convert boolean result to int (1 for
                // true, 0 for false)
                int x = knows(i, j, matrix) ? 1 : 0;

                // set the degrees
                outdegree[i] += x;
                indegree[j] += x;
            }
        }

        // find a person with indegree n-1 and out degree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        
        int[][] matrix = { { 0, 0, 1, 0 },
                           { 0, 0, 1, 0 },
                           { 0, 0, 0, 0 },
                           { 0, 0, 1, 0 } };
        
        int id = findCelebrity(n, matrix);
        
        if (id == -1) {
            System.out.println("No celebrity");
        }
        else {
            System.out.println("Celebrity ID " + id);
        }
    }
}
