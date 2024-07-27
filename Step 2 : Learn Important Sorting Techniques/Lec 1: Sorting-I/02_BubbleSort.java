// Question Link: https://www.geeksforgeeks.org/problems/bubble-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bubble-sort 

// Theory: https://takeuforward.org/data-structure/bubble-sort-algorithm/


class Solution {
    //Function to sort the array using bubble sort algorithm.
    // Time Complexity = O(n^2), Space Complexity = O(1)
	public static void bubbleSort(int arr[], int n) {
	    
        // Iterate over the array.
        for (int i = 0; i < n; i++) {
            // Initialize a flag to check if any swaps occurred in this pass.
            boolean didSwap = false; 
    
            // Iterate over the array up to the sorted portion.
            for (int j = 0; j < n - 1 - i; j++) {
                
                // Compare adjacent elements and swap if they are in the wrong order.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; // Temporarily store the value of arr[j].
                    arr[j] = arr[j + 1]; // Assign the value of arr[j + 1] to arr[j].
                    arr[j + 1] = temp; // Assign the temporary value to arr[j + 1].
        
                    // Set the flag to true indicating a swap occurred.
                    didSwap = true; 
                }
            }
    
            // If no swaps occurred, the array is already sorted, so break out of the loop.
            if (!didSwap) {
                break;
            }
        }
    }
}


// Note: Bubble Sort is Inplace Sorting and also Stable Algorithm.
// Inplace Sorting: Not taking any extra space
// Stable Algorithm: Order Precedence not follow if 2 same elements here.
