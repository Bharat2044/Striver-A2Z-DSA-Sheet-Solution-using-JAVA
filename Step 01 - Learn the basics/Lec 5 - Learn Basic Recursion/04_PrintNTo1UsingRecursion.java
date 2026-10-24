// Question Link: https://www.geeksforgeeks.org/problems/print-n-to-1-without-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-n-to-1-without-loop


class Solution {

    // Time Complexity = O(N), Space Complexity = O(N)
    public void printNos(int N) {
        // Base case: if N is 0, simply return without doing anything
        if (N == 0) {
            return;
        }
        
        // After the recursive call, print the current value of N
        System.out.print(N + " ");
        
        // Recursive call: first, process (print) all numbers from N-1 down to 1
        printNos(N - 1);
    }

}
