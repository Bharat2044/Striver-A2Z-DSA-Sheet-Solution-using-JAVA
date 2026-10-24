// Question Link: https://www.geeksforgeeks.org/problems/insertion-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insertion-sort


class Solution {
    
  // Function to insert the element at the correct position in the sorted part of the array.
    static void insert(int arr[], int i) {
        // Base case: If i is 0 or the element is already in the correct position.
        if (i == 0 || arr[i - 1] <= arr[i]) {
            return;
        }

        // Swap the elements if they are in the wrong order.
        int temp = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = temp;

        // Recursively call insert for the previous element.
        insert(arr, i - 1);
    }

    // Function to sort the array using the insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        // Base case: If the array size is 1, it's already sorted.
        if (n <= 1) {
            return;
        }

        // Recursively sort the first n-1 elements.
        insertionSort(arr, n - 1);

        // Insert the nth element in the correct position within the sorted array.
        insert(arr, n - 1);
    }
}
