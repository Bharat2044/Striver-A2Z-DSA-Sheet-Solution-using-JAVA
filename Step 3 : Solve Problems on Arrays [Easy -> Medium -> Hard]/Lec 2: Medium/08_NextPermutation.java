// Question Link: https://leetcode.com/problems/next-permutation/description/


class Solution {
    // Time Complexity = O(n), Space Complexity = O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // Step 1: Find the rightmost element that is smaller than its successor.
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If no such element is found, reverse the entire array.
        if (i < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Step 2: Find the smallest element on the right side of nums[i] which is larger than nums[i].
        int j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        
        // Step 3: Swap elements at i and j.
        swap(nums, i, j);
        
        // Step 4: Reverse the sequence from i + 1 to the end of the array.
        reverse(nums, i + 1, n - 1);
    }
    
    // Helper method to reverse a portion of the array.
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    // Helper method to swap elements in the array.
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
