// Question Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/


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
    // 1st Approach: Brute Force Approach(Using 2 Iterations) - Time Complexity = O(n), Space Complexity = O(1)
    public ListNode deleteMiddle(ListNode head) {
        // Create a temporary pointer 'temp' to traverse the list
        ListNode temp = head;
        
        int n = 0;  // Initialize a variable to store the number of nodes
        
        // First pass: Count the total number of nodes in the list
        while (temp != null) {
            n++;  // Increment the node count
            temp = temp.next;  // Move to the next node
        }
        
        // If the list has only one node, return null (as the middle node is also the head)
        if (n == 1) {
            return null;
        }
        
        // Calculate the index of the middle node (integer division rounds down)
        int res = n / 2;
        
        // Reset the 'temp' pointer to the head for the second traversal
        temp = head;
        
        // Traverse the list until reaching the node just before the middle node
        while (temp != null) {
            
            res--;  // Decrement the counter on each step
            
            // If the node just before the middle node is found
            if (res == 0) {
                // Store the middle node in a temporary variable
                ListNode middle = temp.next;
                
                // Skip over the middle node by adjusting the pointers
                temp.next = temp.next.next;
                
                break;  // Middle node has been deleted, so exit the loop
            }

            // Move to the next node
            temp = temp.next;
        }

        // Return the updated list starting from the original head
        return head;
    }
    */

    // 2nd Approach: Brute Force Approach(Using 2 Pointers) - Time Complexity = O(n), Space Complexity = O(1)
    public ListNode deleteMiddle(ListNode head) {
        // If the list is empty or has one node, return null
        if (head == null || head.next == null)
            return null;

        // Initialize slow pointer at head, fast pointer two steps ahead
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move fast two steps and slow one step until fast reaches the end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move fast two steps
            slow = slow.next;       // Move slow one step
        }

        // Skip the middle node
        slow.next = slow.next.next;

        // Return the modified list
        return head;
    }
}
