// Question Link: https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n), Space Complexity = O(n)
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        
        // Initialize a 2D ArrayList to store the resulting pairs of integers.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
        // HashSet to store the values of the nodes for quick lookup.
        HashSet<Integer> hs = new HashSet<>();
    
        // Temporary pointer to traverse the linked list.
        Node temp = head;
    
        // First loop: Traverse the linked list to add all node values to the HashSet.
        while(temp != null) {
            // Add the current node's data to the HashSet.
            hs.add(temp.data);
    
            // Move to the next node.
            temp = temp.next;
        }
    
        // Second loop: Traverse the linked list again to find pairs that sum to the target.
        while(head != null) {
            // Remove the current node's value from the HashSet to avoid pairing with itself.
            hs.remove(head.data);
    
            // Check if the complement of the current node's value (target - head.data) exists in the HashSet.
            if(hs.contains(target - head.data)) {
                // Create a new pair (ArrayList) to store the current value and its complement.
                ArrayList<Integer> l = new ArrayList<>();
                
                l.add(head.data);                // Add the current node's value.
                l.add(target - head.data);       // Add the complement (target - current value).
    
                // Add the pair to the final result list.
                ans.add(l);
            }
    
            // Move to the next node in the linked list.
            head = head.next;
        }
    
        // Return the list of pairs that sum to the target.
        return ans;
    }
    */
    
    // 2nd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O()
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // Create an ArrayList to store the pairs of integers whose sum equals the target
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // Find the tail of the linked list (the last node) by traversing from the head
        Node tail = head;
        while (tail.next != null) {
            // Move to the next node until reaching the last node
            tail = tail.next;
        }
        
        // Initialize two pointers: 'left' starting at the head, and 'right' starting at the tail
        Node left = head;
        Node right = tail;
        
        // Iterate through the list until the two pointers meet or cross
        while (left != null && right != null && left != right && right.next != left) {
            // Calculate the sum of the values at the left and right pointers
            int sum = left.data + right.data;
            
            // If the sum equals the target, store the pair in the result list
            if (sum == target) {
                // Create a new ArrayList to store the pair
                ArrayList<Integer> pair = new ArrayList<>();
                
                pair.add(left.data); // Add the value of the left pointer to the pair
                pair.add(right.data); // Add the value of the right pointer to the pair
                result.add(pair); // Add the pair to the final result list
                
                
                left = left.next; // Move the left pointer forward to the next node
                right = right.prev; // Move the right pointer backward to the previous node
            }
            // If the sum is less than the target, move the left pointer forward
            else if (sum < target) {
                left = left.next;
            }
            // If the sum is greater than the target, move the right pointer backward
            else {
                right = right.prev;
            }
        }
        
        // Return the list of pairs that sum to the target
        return result;
    }
}
