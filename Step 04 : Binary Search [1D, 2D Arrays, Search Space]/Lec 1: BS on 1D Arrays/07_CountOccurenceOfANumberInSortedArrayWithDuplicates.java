// Question Link: https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence


class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Linear Search) - Time Complexity = O(n), Space Complexity = O(1)
    int count(int[] arr, int n, int x) {
        // Initialize a counter variable to keep track of the number of occurrences of 'x' in the array.
        int count = 0;
        
        // Loop through each element in the array.
        for (int i = 0; i < n; i++) {
            // Check if the current element matches the target value 'x'.
            if (arr[i] == x) {
                // If a match is found, increment the counter.
                count++;
            }
        }
        
        // Return the final count of occurrences of 'x' in the array.
        return count;
    }
    */
    
    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(n)), Space Complexity = O(1)
    int count(int[] arr, int n, int x) {
        // Find the index of the first occurrence of 'x' in the array
        int firstOccurrence = findFirstOccurrence(arr, n, x);
        
        // If 'x' is not present in the array, return 0
        if (firstOccurrence == -1) {
            return 0;
        }
        
        // Find the index of the last occurrence of 'x' in the array
        int lastOccurrence = findLastOccurrence(arr, n, x);
        
        // The count of 'x' is the difference between the indices of last and first occurrences, plus one
        return lastOccurrence - firstOccurrence + 1;
    }
    
    int findFirstOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid potential overflow
            
            if (arr[mid] == x) {
                result = mid;  // Record the index of the first occurrence
                high = mid - 1; // Move to the left half to find an earlier occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;  // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        
        return result;  // Return the index of the first occurrence
    }
    
    int findLastOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // To avoid potential overflow
            
            if (arr[mid] == x) {
                result = mid;  // Record the index of the last occurrence
                low = mid + 1; // Move to the right half to find a later occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;  // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }
        
        return result;  // Return the index of the last occurrence
    }
}
