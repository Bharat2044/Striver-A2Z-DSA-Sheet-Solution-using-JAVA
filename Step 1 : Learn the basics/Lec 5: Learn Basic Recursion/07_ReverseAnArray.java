// Question Link: https://www.geeksforgeeks.org/program-to-reverse-an-array/


import java.util.Scanner;

public class ReverseAnArray {

    // Function to print array elements
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line after printing the array
    }

    // Function to reverse the array using recursion
    // Time Complexity (TC) = O(n), Space Complexity (SC) = O(n)
    static void reverseArray(int arr[], int start, int end) {
        // Base case: if the start index is greater than or equal to the end index, stop recursion
        if (start < end) {
            // Swap the elements at start and end indices
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            
            // Recursively reverse the subarray
            reverseArray(arr, start + 1, end - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the size of the array from the user
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        
        // Initialize the array with the specified size
        int[] arr = new int[n];
        
        // Read array elements from the user
        System.out.println("Enter Array Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Print the array before reversing
        System.out.println("Array Elements Before Reversed: ");
        printArray(arr);
        
        // Reverse the array
        reverseArray(arr, 0, n - 1);
        
        // Print the array after reversing
        System.out.println("Array Elements After Reversed: ");
        printArray(arr);
        
        // Close the scanner
        sc.close();
    }
}
