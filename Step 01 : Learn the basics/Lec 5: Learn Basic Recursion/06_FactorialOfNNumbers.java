// Question Link: https://www.geeksforgeeks.org/problems/find-all-factorial-numbers-less-than-or-equal-to-n3548/0?problemType=functional&difficulty%255B%255D=-1&page=1&query=problemTypefunctionaldifficulty%255B%255D-1page1

// User function Template for Java
class Solution {
    
    // Recursive helper function to find factorial numbers
    static void findFactorials(long n, long currentFactorial, long currentNumber, ArrayList<Long> factorialList) {
        // Base case: if the current factorial exceeds n, stop recursion
        if (currentFactorial > n) {
            return;
        }
        
        // Add the current factorial to the list
        factorialList.add(currentFactorial);
        
        // Compute the next factorial and recurse
        findFactorials(n, currentFactorial * (currentNumber + 1), currentNumber + 1, factorialList);
    }

    // 1st Approach: Using Recursion - Time Complexity = O(k), Space Complexity = O(k), Where k is the number of factorial numbers.
    static ArrayList<Long> factorialNumbers(long n) {
        
        // Initialize an ArrayList to store the factorial numbers less than or equal to n
        ArrayList<Long> factorialList = new ArrayList<>();
        
        // Start recursion with initial values: 1! = 1, and starting number is 1
        findFactorials(n, 1, 1, factorialList);
        
        // Return the list of factorial numbers
        return factorialList;
    }
    
    /*
    // 2nd Approach: Using Loops - Time Complexity = O(k), Space Complexity = O(k), Where k is the number of factorial numbers.
    static ArrayList<Long> factorialNumbers(long n) {
        // Initialize an ArrayList to store the factorial numbers less than or equal to n
        ArrayList<Long> factorialList = new ArrayList<>();
        
        // Initialize the variable to hold the current factorial value, starting with 1 (0! and 1!)
        long currentFactorial = 1;
        
        // Initialize a variable for the current number to calculate factorial
        long currentNumber = 1;
        
        // Loop to compute factorials and check if they are <= n
        while (currentFactorial <= n) {
            // Add the current factorial to the list
            factorialList.add(currentFactorial);
            
            // Move to the next number and compute the next factorial
            currentNumber++;
            currentFactorial *= currentNumber;
        }
        
        // Return the list of factorial numbers
        return factorialList;
    }
    */
}




// Question Link: https://www.geeksforgeeks.org/problems/factorial5739/1

class Solution{
    // 1st Approach: Using Recursion - Time Complexity = O(N), SPace Complexity = O(N)
    static long factorial(int N) {
        // Base case: if N is 0 or 1, return 1 because 0! = 1! = 1
        if (N == 0 || N == 1) {
            return 1;
        }
        
        // Recursive case: return N multiplied by the factorial of (N - 1)
        return N * factorial(N - 1);
    }
    
    
    /*
    // 2nd Approach: Using Loops - Time Complexity = O(N), SPace Complexity = O(1)
    static long factorial(int N) {
        // Initialize sum to 1, which will hold the result of the factorial calculation
        long sum = 1;
        
        // Loop from 2 to N (inclusive) to compute the factorial iteratively
        for (int i = 2; i <= N; i++) {
            sum *= i;  // Multiply the current value of sum by i
        }
        
        // Return the computed factorial
        return sum;
    }
    */
}

