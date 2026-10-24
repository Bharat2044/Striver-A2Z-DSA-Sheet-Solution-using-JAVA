// Question Link: https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * m), Space Complexity = O(1)
    public int rowWithMax1s(int arr[][]) {
        // Initialize a variable to keep track of the maximum count of 1s found in any row.
        int maxCount = 0;
        
        // Initialize the index variable to store the row index with the maximum 1s. Set it to -1 initially.
        // -1 indicates that no such row with 1s has been found yet.
        int index = -1;
    
        // Loop through each row of the 2D array.
        for (int i = 0; i < arr.length; i++) {
    
            // Initialize a variable to count the number of 1s in the current row.
            int onesCount = 0;
    
            // Loop through each element of the current row.
            for (int j = 0; j < arr[i].length; j++) {
                
                // Check if the current element is 1.
                if (arr[i][j] == 1) {
                    
                    // Increment the count of 1s for the current row.
                    onesCount++;
                }
            }
    
            // After counting 1s in the current row, check if it has more 1s than the previous maxCount.
            if (onesCount > maxCount) {
                
                // Update maxCount to the current row's count of 1s.
                maxCount = onesCount;
    
                // Update the index to the current row's index, since it has the most 1s so far.
                index = i;
            }
        }
    
        // Return the index of the row with the most 1s, or -1 if no row with 1s was found.
        return index;
    }
    */
    
    
    /*
    // Function to find the first occurrence of a value greater than or equal to x using binary search
    public static int lowerBound(int[] arr, int n, int x) {
        // Initialize low and high pointers
        int low = 0, high = n - 1;  
        
        // Default answer set to n, indicating no such element found
        int ans = n;  
    
        // Binary search loop
        while (low <= high) {
            // Calculate the mid index
            int mid = (low + high) / 2;  
            
            // Check if the middle element is greater than or equal to x
            if (arr[mid] >= x) {
                ans = mid;  // Potential answer found
                high = mid - 1;  // Look for a smaller index on the left
            } else {
                low = mid + 1;  // Move to the right half
            }
        }
        
        // Return the first index of an element >= x
        return ans;  
    }
    
    // 2nd Approach: Better Solution (Using Binary Search) - Time Complexity: O(n * log(m)), Space Complexity: O(1)
    public int rowWithMax1s(int arr[][]) {
        // Track the maximum count of 1s found
        int maxCount = 0;  
        
        // Index of the row with the most 1s
        int index = -1;    
    
        // Iterate through each row
        for (int i = 0; i < arr.length; i++) {
            // Get the number of columns in the current row
            int m = arr[i].length;  
            
            // Use lowerBound to find the first occurrence of 1 and count the number of 1s
            int onesCount = m - lowerBound(arr[i], m, 1);
            
            // Update maxCount and index if the current row has more 1s than previously found.
            if (onesCount > maxCount) {
                maxCount = onesCount;
                index = i;
            }
        }
    
        // Return the index of the row with the most 1s.
        return index; 
    }
    */
    
    // 3rd Approach: Optimal Solution - Time Complexity: O(n + m), Space Complexity: O(1)
    public int rowWithMax1s(int arr[][]) {

        // Initialize variable to track the row index with the most 1s.
        int maxRowIndex = -1;
    
        // Get the number of rows in the matrix.
        int rows = arr.length;
    
        // Get the number of columns in the matrix.
        int cols = arr[0].length;
    
        // Start from the top-right corner of the matrix.
        int j = cols - 1;
    
        // Iterate through each row of the matrix.
        for (int i = 0; i < rows; i++) {
    
            // Move left while there are 1s in the current row.
            while (j >= 0 && arr[i][j] == 1) {
    
                // Move left to find more 1s in the current row.
                j--;
    
                // Update the index of the row with the most 1s.
                maxRowIndex = i;
            }
        }
    
        // Return the index of the row that has the most 1s.
        return maxRowIndex;
    }
}
