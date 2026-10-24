// Question Link: https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array


class Solution {
    // Function to find the leaders in the array.
    
    /*
    // 1st Approah: Brute Force Approach (Using 2 Loops) - Time Complexity = O(n^2), Space Complexity = O(n)
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Create a list to store the leader elements.
        ArrayList<Integer> ans = new ArrayList<>();
    
        // Iterate through the array up to the second last element.
        for (int i = 0; i < n - 1; i++) {
            // Assume the current element is a leader.
            boolean leaders = true;
    
            // Compare the current element with the elements to its right.
            for (int j = i + 1; j < n; j++) {
                // If any element to the right is larger, the current element is not a leader.
                if (arr[j] > arr[i]) {
                    leaders = false;
                    break;
                }
            }
    
            // If the current element is larger than all elements to its right, add it to the list.
            if (leaders) {
                ans.add(arr[i]);
            }
        }
    
        // The last element is always a leader.
        ans.add(arr[n - 1]);
    
        // Return the list of leaders.
        return ans;
    }
    */
    
    /*
    // 2nd Approah: Better Approach (Using Stack) - Time Complexity = O(n), Space Complexity = O(n)
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Create a stack to help identify leader elements.
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the array from right to left.
        for (int i = n - 1; i >= 0; i--) {
            // If the stack is empty or the current element is greater than or equal to the stack's top element,
            // it means the current element is a leader.
            if (stack.isEmpty() || arr[i] >= stack.peek()) {
                stack.push(arr[i]);
            }
        }
        
        // Create a list to store the leader elements.
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Pop all elements from the stack and add them to the list. The order will be from right to left.
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        
        // Return the list of leaders.
        return ans;
    }
    */
    
    // 3rd Approah: Optimal Approach - Time Complexity = O(n), Space Complexity = O(n)
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Create a list to store the leader elements.
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Initialize maxFromRight with the last element of the array.
        int maxFromRight = arr[n - 1];
        
        // Add the last element to the list as it is always a leader.
        ans.add(maxFromRight);
        
        // Iterate through the array from the second last element to the first element.
        for (int i = n - 2; i >= 0; i--) {
            // If the current element is greater than maxFromRight, it is a leader.
            if (arr[i] >= maxFromRight) {
                // Update maxFromRight to the current element.
                maxFromRight = arr[i];
                
                // Add the current element to the list of leaders.
                ans.add(maxFromRight);
            }
        }
        
        // Reverse the list to maintain the order from left to right as in the original array.
        Collections.reverse(ans);
        
        // Return the list of leaders.
        return ans;
    }
}
