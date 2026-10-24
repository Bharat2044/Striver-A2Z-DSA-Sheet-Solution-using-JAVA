// Question Link: https://www.naukri.com/code360/problems/nth-fibonacci-number_74156?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


import java.util.Scanner;
public class Solution {

	/*
	// 1st Approach: Using Recursion - Time Complexity = O(2^n), Space Complexity = O(n)
	static int fibonacci(int n){
		// Base cases: If n is equa to 1 or 2, then directly return 1
        if (n == 1 || n == 2)
            return 1;

        // Recursive call for the nth Fibonacci number
        return fibonacci(n - 1) + fibonacci(n - 2);
	}
	*/

	// 2nd Approach: Using Loops - Time Complexity = O(n), Space Complexity = O(1)
	static int fibonacci(int n) {
        // Initialize variables to store the first two Fibonacci numbers
        int a = 0, b = 1;
        
        // Loop from 1 to n to calculate the Fibonacci sequence iteratively
        for (int i = 1; i <= n; i++) {
            // Calculate the next Fibonacci number
            int c = a + b;
            
            // Update a and b to the next pair of Fibonacci numbers
            a = b;
            b = c;
        }
        
        // Return the nth Fibonacci number
        return a;
    }


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(fibonacci(n));
	}
}
