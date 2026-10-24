// Question Link: https://www.geeksforgeeks.org/problems/quick-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=quick-sort


class Solution {
    
    //Function to sort an array using quick sort algorithm.
    // Time Complexity = O(n^2), Space Complexity = O(n)
    static void quickSort(int arr[], int low, int high) {
        // Check if the array can be partitioned; base condition for recursion
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);
    
            // Recursively sort elements before the pivot
            quickSort(arr, low, pivotIndex - 1);
    
            // Recursively sort elements after the pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    // Function to partition the array around a pivot and return the pivot index
    static int partition(int arr[], int low, int high) {
        // Choose the pivot element; here, the first element is chosen as the pivot
        int pivot = arr[low];
        int i = low; // `i` keeps track of the position where elements smaller than the pivot will be placed
    
        // Loop through the array, rearranging elements based on the pivot
        for (int j = low + 1; j <= high; j++) {
            // If the current element is less than the pivot, place it in the correct position
            if (arr[j] < pivot) {
                i++; // Increment `i` to move the boundary of smaller elements
    
                // Swap the element at `j` with the element at `i`
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    
        // Swap the pivot element with the element at index `i` to place the pivot in the correct position
        int temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;
    
        // Return the index of the pivot after partitioning
        return i;
    } 
}
