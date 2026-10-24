// Question Link: https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n), Space Complexity = O(n)
    public void rotate(int[] arr) {
        // Get the length of the array.
        int n = arr.length; 
        
        // Create a temporary array to store the rotated elements.
        int[] temp = new int[n]; 
        
        // First loop: Shift elements to the right by one position.
        for (int i = 1; i < n; i++) {
            temp[i] = arr[i - 1]; // Shift each element of arr to the right in temp.
        }
        
        // Place the last element of arr at the first position in temp.
        temp[0] = arr[n - 1]; 
        
        // Second loop: Copy the rotated elements from temp back into the original array arr.
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i]; // Update the original array with the rotated elements.
        }
    }
    */
    
    
    // 2nd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    public void rotate(int[] arr) {
        // Get the length of the array.
        int n = arr.length; 
    
        // Store the last element in a temporary variable.
        int temp = arr[n - 1]; 
    
        // Shift elements from the end to the beginning by one position to the right.
        for (int i = n - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
    
        // Place the last element (stored in temp) at the first position.
        arr[0] = temp;        
    }
}


