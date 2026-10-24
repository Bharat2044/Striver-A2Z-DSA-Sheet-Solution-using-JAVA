// Question Link: https://leetcode.com/problems/next-greater-element-i/description/


class Solution {

    // Time Complexity = O(nums1.length + nums2.length), Space Complexity = O(nums2.length)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Map to store next greater elements in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        // Stack to track decreasing elements
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 to populate nextGreaterMap
        for (int num : nums2) {
            // Find next greater element for stack top
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num); // Push current element
        }
        
        // Remaining elements have no greater element
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }
        
        // Build result for nums1 using nextGreaterMap
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

       // return the result
        return result;
    }
}
