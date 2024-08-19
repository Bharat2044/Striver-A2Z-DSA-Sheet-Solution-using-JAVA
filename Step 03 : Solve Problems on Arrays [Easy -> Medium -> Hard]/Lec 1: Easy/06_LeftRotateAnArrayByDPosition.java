// Question Link: https://leetcode.com/problems/rotate-array/description/


class Solution {
    
    /*
    // 1st Approach: Using Rotate One by One => TC = O(n * k), SC = O(1)
    public void rotate(int[] nums, int k) {
        // Length of the array
        int n = nums.length;
        
        // Adjust `k` if it is greater than the size of the array
        k = k % n;
        
        // Rotate the array `k` times by one position each time
        for (int i = 1; i <= k; i++) {
            rightRotateByOne(nums);
        }
    }

    static void rightRotateByOne(int[] nums) {
        // Length of the array
        int n = nums.length; 
        
        // Store the last element of the array
        int x = nums[n - 1];
        
        // Shift elements to the right by one position
        for (int i = n - 1; i >= 1; i--) {
            nums[i] = nums[i - 1];
        }
        
        // Place the stored element at the beginning of the array
        nums[0] = x;
    }
    */

    /*
    // 2nd Approach: Using Extra Space => TC = O(n), SC = O(n)
    public void rotate(int[] nums, int k) {
        // Length of the array
        int n = nums.length; 

        // Adjust `k` to handle cases where `k` is larger than the length of the array
        k = k % n; // Reduces `k` to be within the bounds of the array length

        // Create a temporary array to hold the rotated version of the original array
        int[] temp = new int[n]; 

        // Index for placing elements in the `temp` array
        int j = 0; 
        
        // Copy the last `k` elements from the original array to the beginning of `temp`
        for (int i = n - k; i < n; i++) {
            temp[j] = nums[i]; // Place the element at index `i` of `nums` into `temp`

            j++; // Move to the next position in `temp`
        }
        
        // Copy the first `n - k` elements from the original array to the end of `temp`
        for (int i = 0; i < n - k; i++) {
            temp[j] = nums[i]; // Place the element at index `i` of `nums` into `temp`

            j++; // Move to the next position in `temp`
        }
        
        // Copy the elements from the `temp` array back into the original array `nums`
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i]; 
        }
    }
    */


    // 3rd Approach: Using Reverse Array => TC = O(n), SC = O(1)
    public void rotate(int[] nums, int k) {
        // Length of the array
        int n = nums.length; 

        // Adjust `k` to handle cases where `k` is larger than the length of the array
        // `k` might be larger than `n`, so `k % n` ensures it is within the valid range
        k = k % n;

        // Reverse the last `k` elements of the array
        // This prepares the last `k` elements to be placed at the start after full rotation
        reverse(nums, n - k, n - 1);
        
        // Reverse the first `n-k` elements of the array
        // This prepares the first `n-k` elements to be in the correct order after moving them to the end
        reverse(nums, 0, n - k - 1);
        
        // Reverse the entire array
        // This final reversal ensures that the entire array is in the correct rotated order
        reverse(nums, 0, n - 1);
    }
        
    // Helper method to reverse a portion of the array from index `s` to index `e`
    public static void reverse(int[] nums, int s, int e) {
        // Continue swapping elements until `s` crosses `e`
        while (s < e) {
            // Swap the elements at indices `s` and `e`
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            
            // Move the start index `s` towards the end and the end index `e` towards the start
            s++;
            e--;
        }
    }

}
