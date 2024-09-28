// Question Link: https://leetcode.com/problems/sort-list/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * log(n)), Space Complexity = O(n)
    public ListNode sortList(ListNode head) {
        // Create a list to store the values of the linked list
        List<Integer> arr = new ArrayList<>();
        
        // Create a temporary pointer to traverse the linked list
        ListNode temp = head;
        
        // Traverse the linked list and store each node's value in the array list
        while (temp != null) {
            arr.add(temp.val);  // Add current node's value to the list
            temp = temp.next;   // Move to the next node
        }
        
        // Sort the array list containing the node values
        Collections.sort(arr);
        
        // Reset the temporary pointer to the head of the linked list
        temp = head;
        
        // Assign the sorted values back to the original linked list
        for (int i = 0; i < arr.size(); i++) {
            temp.val = arr.get(i);  // Update the current node's value
            temp = temp.next;       // Move to the next node
        }
        
        // Return the sorted linked list
        return head;
    }
    */

    // Helper function to merge two sorted linked lists
    private ListNode merge(ListNode left, ListNode right) {
        // Dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Traverse both lists and merge them in sorted order
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // Append any remaining nodes from the left or right list
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }
        
        // Return the merged list starting from the next node of the dummy node
        return dummy.next;
    }

    // Helper function to find the middle of the linked list using the slow and fast pointer approach
    private ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast pointer two steps and slow pointer one step until fast reaches the end
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Slow will now point to the middle node
        return slow;
    }

    // 2nd Approach: Optimal Approach - Time Complexity = O(n * log(n)), Space Complexity = O(1)
    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or contains a single node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle point to split the list into two halves
        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        
        // Split the list into two halves by making the middle's next node null
        middle.next = null;
        
        // Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);
        
        // Merge the two sorted halves
        return merge(left, right);
    }
}
