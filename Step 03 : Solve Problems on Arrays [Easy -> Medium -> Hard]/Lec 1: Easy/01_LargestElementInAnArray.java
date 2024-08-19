// Question Link: https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n^2), Space Complexity = O(1)
    public static int largest(int n, int[] arr) {

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            
            // Check if there's any element larger than the current element
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    flag = false; // Found a larger element
                    break;
                }
            }
            
            // If no larger element was found, the current element is the largest
            if (flag == true)
                return arr[i];
        }
        
        return -1; // This return statement is just a fallback, should not be reached
    }
    */
    
    /*
    // 2nd Approach: Using Sorting - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public static int largest(int n, int[] arr) {

        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // The largest element will be the last element in the sorted array
        return arr[n - 1];
    }
    */
    
    /*
    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    public static int largest(int n, int[] arr) {

        // Initialize max with the first element of the array
        int max = arr[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Update max if the current element is larger
            if (arr[i] > max)
                max = arr[i];
        }
        
        // Return the largest element
        return max;
    }
    */
    
    // 4th Approach: Using Recursion - Time Complexity = O(n), Space Complexity = O(n)
    public static int largest(int n, int[] arr) {
    
        // Base case: When the size of the sub-array is 1, return the only element
        if (n == 1) {
            return arr[0];
        }
        
        // Recursive case: Find the largest element in the sub-array excluding the last element
        // Compare the last element of the current sub-array with the largest element found in the rest
        return Math.max(arr[n - 1], largest(n - 1, arr));
    }
}
