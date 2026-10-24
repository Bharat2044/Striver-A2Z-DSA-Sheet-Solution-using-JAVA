// Question Link: https://leetcode.com/problems/sliding-window-maximum/


class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity: O(n * k), Space Complexity: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // Check if the input array is empty
        if (nums.length == 0) {
            return new int[0]; // Return an empty array if nums is empty
        }
        
        // Array to store the maximum values for each window
        // Size of result array is `nums.length - k + 1` since we have that many windows
        int[] result = new int[nums.length - k + 1];
        
        // Iterate through each possible starting index of the sliding window
        for (int i = 0; i <= nums.length - k; i++) {
            // Initialize max as the first element in the current window
            int max = nums[i];
            
            // Iterate through the remaining elements in the window of size `k`
            for (int j = 1; j < k; j++) {
                // Update max with the maximum value in the current window
                max = Math.max(max, nums[i + j]);
            }
            
            // Store the maximum value of the current window in the result array
            result[i] = max;
        }
        
        // Return the result array containing max values for each sliding window
        return result;
    }
    */

    // 2nd Approach: Optimal Solution - Time Complexity: O(n), Space Complexity: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // Check if the input array is empty
        if (nums.length == 0) {
            return new int[0]; // Return an empty array if there are no elements
        }
        
        // Array to store the maximum values for each window
        int[] result = new int[nums.length - k + 1];

        // Index to keep track of the result array position
        int resultIndex = 0; 
        
        // Deque to store indices of elements in the current window
        // We store indices rather than values to track the window start and end positions
        Deque<Integer> deque = new LinkedList<>();
        
        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            
            // Remove elements from the front if they are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst(); // Remove index from front if it falls outside the window
            }
            
            // Remove elements from the back of the deque if they are less than the current element
            // as they cannot be the maximum for this or future windows
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast(); // Remove index from back as current element is larger
            }
            
            // Add the current element's index to the deque
            deque.offerLast(i);
            
            // If we have processed at least k elements, add the max of the current window to the result
            // The maximum for the window is the element at the front of the deque
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        
        // Return the result array containing max values for each sliding window
        return result;
    }
}

