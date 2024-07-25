// Question Link: https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1


class Solution {

    // Time Complexity = O(N), Space Complexity = O(N)
    public void printNos(int N) {
        // Base case: if N is 0, simply return without doing anything
        if (N == 0) {
            return;
        }
        
        // Recursive call: first, process (print) all numbers from N-1 down to 1
        printNos(N - 1);
        
        // After the recursive call, print the current value of N
        System.out.print(N + " ");
    }
}
