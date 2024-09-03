// Question Link: https://www.geeksforgeeks.org/problems/merge-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=merge-sort


void merge(int arr[], int l, int m, int r) {
        // Temporary ArrayList to store merged elements
        ArrayList<Integer> temp = new ArrayList<>();
    
        // Initialize pointers for the left and right subarrays
        int left = l;      // Starting index of the left subarray
        int right = m + 1; // Starting index of the right subarray
    
        // Merge elements from both subarrays into the temporary list
        while (left <= m && right <= r) {
            
            // If the current element in the left subarray is smaller or equal
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]); // Add element from the left subarray
                left++;              // Move to the next element in the left subarray
            } else {
                temp.add(arr[right]); // Add element from the right subarray
                right++;              // Move to the next element in the right subarray
            }
        }
    
        // Copy any remaining elements from the left subarray
        while (left <= m) {
            temp.add(arr[left]);
            left++;
        }
    
        // Copy any remaining elements from the right subarray
        while (right <= r) {
            temp.add(arr[right]);
            right++;
        }
    
        // Copy the merged elements back into the original array
        for (int i = l; i <= r; i++) {
            arr[i] = temp.get(i - l);
        }
    }
    
    // Time Complexity = O(n * logn())), Space Complexity = O(n)
    void mergeSort(int arr[], int l, int r) {
        
        // Base case: If the array has one or no elements, it is already sorted
        if (l >= r) {
            return;
        }
    
        // Calculate the middle index to split the array into two halves
        int m = (l + r) / 2;
    
        // Recursively sort the left half of the array
        mergeSort(arr, l, m);
    
        // Recursively sort the right half of the array
        mergeSort(arr, m + 1, r);
    
        // Merge the two sorted halves
        merge(arr, l, m, r);
    }
