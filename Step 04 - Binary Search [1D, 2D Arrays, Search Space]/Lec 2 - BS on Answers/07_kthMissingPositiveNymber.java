// Question Link: https://leetcode.com/problems/kth-missing-positive-number/


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time COmplexity = O(n), Space COmplexity = O(1)
    public int findKthPositive(int[] arr, int k) {

        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
        
            // If the current element is less than or equal to k, k is not missing, so increment k
            if (arr[i] <= k) {
                k++;
            } else {
                // Break the loop if the current element is greater than k, meaning k is missing here
                break;
            }
        }

        // Return the kth missing positive integer
        return k;
    }
    */

    // 2nd Approach: Optimal Approach (Using Binary Search) - Time COmplexity = O(log(n)), Space COmplexity = O(1)
    public int findKthPositive(int[] arr, int k) {

        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search untill left is less than and equal to right
        while (left <= right) {
            // Calculate the mid-point of the current search range
            int mid = left + (right - left) / 2;

            // Calculate the number of missing integers up to arr[mid]
            int missing = arr[mid] - (mid + 1);

            // If fewer than k numbers are missing, search the right half
            if (missing < k) {
                left = mid + 1;
            } else {
                // Otherwise, search the left half
                right = mid - 1;
            }
        }

        // Calculate and return the k-th missing positive integer
        return left + k;
    }
}
