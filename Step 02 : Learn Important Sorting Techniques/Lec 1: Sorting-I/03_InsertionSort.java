// Question Link: https://www.geeksforgeeks.org/problems/insertion-sort/0?category%5B%5D=Algorithms&page=1&query=category%5B%5DAlgorithmspage1&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=insertion-sort

// Theory: https://takeuforward.org/data-structure/insertion-sort-algorithm/


class Solution {

    static void insert(int arr[], int i) {

        // Continue shifting elements to the right until the correct position is found
        while (i > 0 && arr[i - 1] > arr[i]) {
          int temp = arr[i];        // Store the current element
          arr[i] = arr[i - 1];      // Shift the previous element to the current position
          arr[i - 1] = temp;        // Place the stored element in the previous position
          
          i--;                      // Move to the previous element
        }
    }

    //Function to sort the array using insertion sort algorithm.
    // Time Complexity = O(n^2), Space Complexity = O(1)
    public void insertionSort(int arr[], int n) {
        //code here
    
    // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
          insert(arr, i);  // Insert element into the sorted portion of the array
        }
    }
}


// Note: Insertion Sort is Inplace Sorting and also Stable Algorithm.
// Inplace Sorting: Not taking any extra space
// Stable Algorithm: Order Precedence not follow if 2 same elements here.
