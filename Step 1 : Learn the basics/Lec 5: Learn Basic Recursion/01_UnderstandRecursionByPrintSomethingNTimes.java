// Question Link: https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=print-1-to-n-without-using-loops


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




// Coding Ninjas Question Link: https://www.naukri.com/code360/problems/print-1-to-n_628290?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&count=25&page=1&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=PROBLEM

public class Solution {

    // Recursive method to fill the array
    public static void solve(int[] arr, int x) {
        // Base case: if x is 0, return without making changes
        if (x == 0) {
            return;
        }

        // Set the x-th position (x-1 index) of the array to the value x
        arr[x - 1] = x;

        // Recursive call: fill the array up to x-1
        solve(arr, x - 1);
    }

    // Method to initialize and fill the array with numbers from 1 to x - Time Complexity = O(N), Space Complexity = O(N)
    public static int[] printNos(int x) {
        // Create an array of size x
        int[] arr = new int[x];

        // Call the recursive method to fill the array
        solve(arr, x);

        // Return the filled array
        return arr;
    }
}
