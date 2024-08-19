// Question Link: https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=who-will-win


class Solution {

    // 1st Approach: Linear Search - Time Complexity = O(n), Space Complexity = O(1)
    static int searchInSorted(int arr[], int N, int K) {
        
        // Iterate through the entire array to search for the element K
        for (int i = 0; i < N; i++) {
            
            // Check if the current element is equal to K, then return 1
            if (arr[i] == K) {
                return 1;
            }
        }
        
        // If the loop completes without finding K, return -1 indicating that K is not present in the array
        return -1;
    }

    
    /*
    // Recursive method to search for element K in the array arr starting from index index
    static int helper(int arr[], int index, int K) {
        // Base case: If the index exceeds the array length, K is not present
        if (index >= arr.length) {
            return -1;
        }
        
        // Check if the current element is equal to K
        if (arr[index] == K) {
            return 1;
        }
        
        // Recursive case: search in the next index
        return helper(arr, index + 1, K);
    }
    
    // 2nd Approach: Recursive Linear Search - Time Complexity = O(n), Space Complexity = O(n)
    static int searchInSorted(int arr[], int N, int K) {
        return helper(arr, 0, K);
    }
    */
    
    /*
    // 3rd Approach: Using Binary Search - Time Complexity = O(n), Space Complexity = O(1)
    static int searchInSorted(int arr[], int N, int K) {
        // Initialize the start and end indices of the search range
        int start = 0, end = N - 1;
        
        // Continue the search while the start index is less than or equal to the end index
        while (start <= end) {
            // Calculate the middle index of the current search range
            int mid = start + (end - start) / 2;
        
            // Check if the middle element is equal to K
            if (arr[mid] == K) {
                // If found, return 1 indicating K is present in the array
                return 1;
            } else if (arr[mid] > K) {
                // If the middle element is greater than K, narrow the search range to the left half
                end = mid - 1;
            } else {
                // If the middle element is less than K, narrow the search range to the right half
                start = mid + 1;
            }
        }
        
        // If the search completes without finding K, return -1 indicating K is not present in the array
        return -1;
    }
    */
}
