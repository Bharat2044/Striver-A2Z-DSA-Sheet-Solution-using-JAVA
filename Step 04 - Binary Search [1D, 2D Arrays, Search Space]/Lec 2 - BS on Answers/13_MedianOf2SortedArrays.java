// Question Link: https://leetcode.com/problems/median-of-two-sorted-arrays/description/


class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Get the lengths of the nums1 arrays.
        int n1 = nums1.length;

        // Get the lengths of the nums2 arrays.
        int n2 = nums2.length;

        // Ensure that nums1 is the smaller array. If not, swap the arrays.
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Calculate the total number of elements in both arrays.
        int n = n1 + n2;
        
        // Calculate the partition point for the combined array.
        int left = (n1 + n2 + 1) / 2;

        // Initialize the binary search bounds.
        int low = 0, high = n1;

        // Perform binary search to find the correct partition.
        while (low <= high) {
            
            // Calculate the midpoints for the current partition in both arrays.
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            // Determine the elements to the left and right of the partition in nums1.
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            
            // Determine the elements to the left and right of the partition in nums2.
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;

            // Determine the elements to the right of the partition in nums1.
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            
            // Determine the elements to the right of the partition in nums2.
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            // Check if the correct partition is found.
            if (l1 <= r2 && l2 <= r1) {
                // If the combined array has an odd number of elements, return the maximum of the left elements.
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } 
                // If the combined array has an even number of elements, return the average of the middle two elements.
                else {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } 
            // If the left part of nums1 is greater than the right part of nums2, adjust the search to the left.
            else if (l1 > r2) {
                high = mid1 - 1;
            } 
            // Otherwise, adjust the search to the right.
            else {
                low = mid1 + 1;
            }
        }

        // Return 0 if no median is found (should not happen in a valid input).
        return 0; 
    }
}
