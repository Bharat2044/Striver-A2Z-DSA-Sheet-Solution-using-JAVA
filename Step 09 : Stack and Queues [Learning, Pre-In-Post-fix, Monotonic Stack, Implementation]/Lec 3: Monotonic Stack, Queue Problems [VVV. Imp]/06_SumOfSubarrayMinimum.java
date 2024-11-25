// Question Link: https://leetcode.com/problems/sum-of-subarray-minimums/description/


class Solution {

    // Time Complexity = O(n), Space Complexity = O(n)
    public int sumSubarrayMins(int[] arr) {
        
        // Modulo constant to avoid overflow
        final int MOD = 1000000007; 

        // Stack to track indices of elements
        Stack<Integer> st = new Stack<>(); 

        // Initialize sum of minimums to accumulate results
        long sumOfMinimums = 0; 

        // Iterate over each element in the array plus one extra iteration
        for (int i = 0; i <= arr.length; i++) {
            
            // Process the element or, in the final iteration, process remaining stack elements
            while (!st.empty() && (i == arr.length || arr[st.peek()] >= arr[i])) {
                // Get the index of the current minimum element
                int mid = st.pop(); 

                int leftBoundary = st.empty() ? -1 : st.peek(); // Left boundary
                int rightBoundary = i; // Right boundary

                // Calculate the number of subarrays where arr[mid] is the minimum
                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                // Add the contribution of arr[mid] to the total sum of minimums
                sumOfMinimums += (count * arr[mid]) % MOD;
                
                sumOfMinimums %= MOD; // Apply modulo to avoid overflow
            }
            
            // Push the current index onto the stack
            st.push(i);
        }

        // Return the sum as an integer
        return (int) sumOfMinimums; 
    }
}
