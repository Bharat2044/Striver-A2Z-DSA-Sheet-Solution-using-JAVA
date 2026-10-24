import java.util.Scanner;

public class PrintSubarrayWithMaximumSum {
    
    /*
    // 1st Approach: Brute Force Approach (Using 3 Loops) - Time Complexity = O(n^3), Space Complexity = O(1)
    public static void printSubarrayWithMaxSum(int[] arr) {
        // If array length is 0, directly return, because no subarray
        if (arr.length == 0) {
            System.out.println("No Subarray");
            return;
        }
            
        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum to the smallest possible integer value
        int startIdx = -1, endIdx = -1;  // Initialize start and end indices of the subarray with the maximum sum

        // Outer loop to consider each possible starting index of the subarray
        for (int i = 0; i < arr.length; i++) {
            // Inner loop to consider each possible ending index of the subarray
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;  // Initialize the current sum for the subarray from i to j

                // Inner loop to calculate the sum of the subarray from index i to j
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }

                // Update maxSum if the current sum is greater and store the start and end indices
                if (currSum > maxSum) {
                    maxSum = currSum;
                    startIdx = i;
                    endIdx = j;
                }
            }
        }

        // Print the maximum subarray sum and its elements
        System.out.print("Subarray with Maximum Sum: ");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    */
    
    /*
    // 2nd Approach: Better Approach (Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(1)
    public static void printSubarrayWithMaxSum(int[] arr) {
        // If array length is 0, directly return, because no subarray
        if (arr.length == 0) {
            System.out.println("No Subarray");
            return;
        }
        
        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum with the smallest possible integer value
        int startIdx = -1, endIdx = -1;  // Initialize start and end indices of the subarray with the maximum sum

        // Iterate over each possible starting index of the subarray
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;  // Initialize currSum to track the sum of the current subarray

            // Iterate over each possible ending index of the subarray
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];  // Add the current element to currSum to include it in the subarray

                // Update maxSum if currSum is greater than the current maxSum and store the start and end indices
                if (currSum > maxSum) {
                    maxSum = currSum;
                    startIdx = i;
                    endIdx = j;
                }
            }
        }

        // Print the maximum subarray sum and its elements
        System.out.print("Subarray with Maximum Sum: ");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    */
    
    /*
    // 3rd Approach: Better Approach (Using Prefix Sum Array) - Time Complexity = O(n), Space Complexity = O(n)
    public static void printSubarrayWithMaxSum(int[] arr) {
        // If array length is 0, directly return, because no subarray
        if (arr.length == 0) {
            System.out.println("No Subarray");
            return;
        }
            
        int minPrefixSum = 0;  // Initialize the minimum prefix sum to 0
        int maxSum = Integer.MIN_VALUE;  // Initialize the maximum subarray sum to the smallest possible value
        int[] prefixSum = new int[arr.length];  // Initialize and compute the prefix sum array
        int startIdx = -1, endIdx = -1;  // Initialize start and end indices of the subarray with the maximum sum
        
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];     
        }
        
        // Loop through the array, keep track of minimum prefix sum so far and maximum subarray sum
        for (int i = 0; i < arr.length; i++) {
            // Calculate the maximum subarray sum ending at index i
            if (prefixSum[i] - minPrefixSum > maxSum) {
                maxSum = prefixSum[i] - minPrefixSum;
                endIdx = i;
            }
            
            // Update the minimum prefix sum so far
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }
        
        // Find the start index of the subarray with the maximum sum
        int sum = 0;
        for (int i = endIdx; i >= 0; i--) {
            sum += arr[i];
            if (sum == maxSum) {
                startIdx = i;
                break;
            }
        }
        
        // Print the maximum subarray sum and its elements
        System.out.print("Subarray with Maximum Sum: ");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    */

    // 4th Approach: Optimal Approach (Using Kadane's Algorithm) - Time Complexity = O(n), Space Complexity = O(1)
    public static void printSubarrayWithMaxSum(int[] arr) {
        // If array length is 0, directly return, because no subarray
        if (arr.length == 0) {
            System.out.println("No Subarray");
            return;
        }

        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum to the smallest possible integer value
        int currSum = 0;  // Initialize currSum to 0 for tracking the current subarray sum
        int start = 0;  // Initialize start index of the current subarray
        int startIdx = -1, endIdx = -1;  // Initialize start and end indices of the subarray with the maximum sum

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if (currSum == 0) {
                start = i;  // Update the start index when currSum is reset
            }
            
            currSum += arr[i];  // Add the current element to currSum

            // Update maxSum if currSum is greater than maxSum and store the start and end indices
            if (currSum > maxSum) {
                maxSum = currSum;
                startIdx = start;
                endIdx = i;
            }

            // Reset currSum to 0 if it becomes negative
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // Print the maximum subarray sum and its elements
        System.out.print("Subarray with Maximum Sum: ");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);  

        // Prompt the user to enter the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Array size can't be less than 0");
            System.exit(0);
        }

        // Create an array of the given size
        int[] arr = new int[n];

        // Prompt the user to enter the elements of the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the desired method to print the maximum subarray sum
        printSubarrayWithMaxSum(arr);

        // Close the scanner
        scanner.close();  
    }
}
