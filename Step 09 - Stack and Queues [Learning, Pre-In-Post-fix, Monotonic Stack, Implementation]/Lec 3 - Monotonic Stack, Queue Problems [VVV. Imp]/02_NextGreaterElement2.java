// Question Link: https://leetcode.com/problems/next-greater-element-ii/description/


class Solution {
    
    // Time Complexity = O(n), Space Complexity = O(n)
    public int[] nextGreaterElements(int[] nums) {
        // Get tjhe size of the array
        int n = nums.length;

        // Store the next greater elements
        int[] result = new int[n];  

        // Stack to store indices
        Stack<Integer> stack = new Stack<>();  
        
        // Initialize result with -1 (default when no greater element is found)
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        
        // Loop twice to simulate circular array
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];  // Circular index access
            
            // Find the next greater element for the top of the stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            
            // Push only first traversal indices to avoid duplicates
            if (i < n) {
                stack.push(i);
            }
        }
        
        // return the result
        return result;
    }
}
