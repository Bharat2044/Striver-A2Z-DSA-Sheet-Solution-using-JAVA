// Question Link: https://www.geeksforgeeks.org/problems/while-loop-printtable-java/1


class Geeks {

  // Time Complexity = O(1), Space Complexity = O(1)
	static void printTable (int n) {
	    // Initialize the variable
        int i = 10;
        
        // Iterate from 10 down to 1
        while (i >= 1) {
            // Print the result of n multiplied by the current value of i, followed by a space
            System.out.print((n * i) + " ");
            
            i--; // Decrement the counter
        }
        
        // Print a newline character to ensure output is formatted correctly
        System.out.println();
    }

}
