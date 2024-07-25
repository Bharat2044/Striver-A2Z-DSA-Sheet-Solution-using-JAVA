// Question Link: https://www.geeksforgeeks.org/problems/print-gfg-n-times/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-gfg-n-times


class Solution {

    /*
    // 1st Approach - Time Complexity = O(N), Space Complexity = O(N)
    void printGfg(int N) {
        // Base case: if N is 0, return without doing anything
        if (N == 0) {
            return;
        }
        
        // Print "GFG" followed by a space
        System.out.print("GFG ");
        
        // Recursive call: print "GFG" N-1 times
        printGfg(N - 1);
    }
    */

    
    // 2nd Approach - Time Complexity = O(N), Space Complexity = O(N)
    void printGfg(int N) {
        // Base case: if N is 0, return without doing anything
        if (N == 0) {
            return;
        }
        
        // Recursive call: print "GFG" N-1 times
        printGfg(N - 1);
        
        // Print "GFG" followed by a space
        System.out.print("GFG ");
    }
}
