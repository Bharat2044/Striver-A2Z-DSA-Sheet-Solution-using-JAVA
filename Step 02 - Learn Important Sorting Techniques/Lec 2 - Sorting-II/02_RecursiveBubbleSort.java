// Question Link: https://www.geeksforgeeks.org/problems/bubble-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bubble-sort


class Solution {
    
    //Function to sort the array using bubble sort algorithm.
    // Time Complexity = O(n^2), Space Complexity = O(n)
	public static void bubbleSort(int arr[], int n) {
        // Base case: If the array has only one element, it is already sorted.
        if (n == 1) {
            return;
        }

        // Boolean flag to check if any swapping occurred during this pass.
        boolean isSwapped = true;

        // Iterate through the array to compare adjacent elements.
        for (int i = 0; i < n - 1; i++) {
            
            // If the current element is greater than the next element, swap them.
            if (arr[i] > arr[i + 1]) {
                
                // Swap arr[i] and arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                // Set the flag to false, indicating a swap has occurred.
                isSwapped = false;
            }
        }

        // If no swaps occurred in this pass, the array is sorted, and we can return.
        if (isSwapped) {
            return;
        }

        // Recursively call the function to sort the remaining elements.
        bubbleSort(arr, n - 1);
    }
}
