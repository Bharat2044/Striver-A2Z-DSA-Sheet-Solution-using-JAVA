// Question Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution {
    public boolean check(int[] nums) {
        int count=0;

        if (nums[0] < nums[nums.length - 1]) {
            count++;
        }
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                count++;
            }

            if(count > 1){
                return false;
            }
        }
        
        return true;
    }   
}



















class CheckIfAnArrayIsSortedOrNot {

  // Method to check if the array is sorted
  /*
  // 1st Approach: Brute Force - Time Complixity = O(n^2), Space Complexity = O(1)
  public static boolean isSorted(int arr[], int n) {
    // Iterate through the array
    for (int i = 0; i < n; i++) {
      // Compare each element with the elements following it
      for (int j = i + 1; j < n; j++) {
        // If a subsequent element is smaller, array is not sorted
        if (arr[j] < arr[i])
          return false;
      }
    }
    // If no unordered pair is found, array is sorted
    return true;
  }
  */
  
  /*
  // 2nd Approach: Optimal Approach - Time Complixity = O(n), Space Complexity = O(1)
  public static boolean isSorted(int arr[], int n) {
    // Iterate through the array starting from the second element
    for (int i = 1; i < n; i++) {
        // Check if the current element is smaller than the previous one
        if (arr[i] < arr[i - 1])
            return false; // Return false if an unordered pair is found
    }
    
    // If no unordered pair is found, array is sorted
    return true;
  }
  */
  
  // 3rd Approach: Using Recursion - Time Complixity = O(n), Space Complexity = O(n)
  public static boolean isSorted(int arr[], int n) {
    // Base case: if the array has one or no elements, it's sorted
    if (n <= 1) {
        return true;
    }

    // Check the last two elements
    if (arr[n - 1] < arr[n - 2]) {
        return false;
    }

    // Recursively check the rest of the array
    return isSorted(arr, n - 1);
  }


  public static void main(String args[]) {
    // Initialize array and its length
    int arr[] = {1, 2, 3, 4, 5}, n = 5;

    // Print the result of the isSorted method
    System.out.println(isSorted(arr, n));
  }
}
