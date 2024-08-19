// Question Link: https://www.geeksforgeeks.org/problems/selection-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=selection-sort

// Theory - https://takeuforward.org/sorting/selection-sort-algorithm/



class Solution {

    // Swaps elements at indices i and j in the array arr.
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];  // Store value at index i in a temporary variable.
        arr[i] = arr[j];    // Assign value at index j to index i.
        arr[j] = temp;      // Assign the temporary value to index j.
    }

    // Finds the index of the smallest element from index i to the end of the array.
    int select(int arr[], int i) {
        // code here such that selectionSort() sorts arr[]
      
        int minIdx = i;  // Initialize the minimum index to i.

        // Iterate over the array starting from i + 1.
        for (int j = i + 1; j < arr.length; j++) {
            // Update minIdx if a smaller element is found.
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }

        return minIdx;  // Return the index of the smallest element.
    }

    // Time Complexity = O(n^2), Space Complexity = O(1)
    void selectionSort(int arr[], int n) {
        //code here
      
        // Iterate over the array.
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the smallest element from i to the end.
            int minIdx = select(arr, i);

            // Swap the smallest element with the element at index i.
            // swap(arr, i, minIdx);
            
            // Swap the smallest element with the element at index i, if i is not equal to minIdx
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }
}


// Note: Selection Sort is an Inplace Sorting, but not Stable Algorithm.
// Inplace Sorting: Not taking any extra space
// Stable Algorithm: Order Precedence not follow if 2 same elements here.
