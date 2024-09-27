// Question Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/


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
    // 1st Approach: Brute Force Approach - Time Complexity = O(L), Time Complexity = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node (res) to act as a new head and connect it to the original head
        ListNode res = new ListNode(0, head);  
        ListNode dummy = res;  // Create a pointer 'dummy' to traverse the list
        
        // Move the head pointer N steps ahead
        for (int i = 0; i < n; i++) {
            head = head.next;  // Advance the head pointer N steps
        }

        // Move both head and dummy pointers until the head pointer reaches the end
        while (head != null) {
            head = head.next;  // Move head one step forward
            dummy = dummy.next;  // Move dummy one step forward
        }

        // Remove the N-th node from the end by skipping it
        dummy.next = dummy.next.next;

        // Return the new list starting from res.next (skipping the dummy node)
        return res.next;        
    }
    */

    
    /*
    // 2nd Approach: Brute Force Approach - Time Complexity = O(L), Time Complexity = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // If the linked list is empty, return null
        if (head == null) {
            return null;
        }

        // Initialize a variable to count the number of nodes in the linked list
        int cnt = 0;

        // Create a temporary pointer to traverse the list
        ListNode temp = head;

        // Traverse the list and count the number of nodes
        while (temp != null) {
            cnt++;  // Increment the node count
            temp = temp.next;  // Move to the next node
        }

        // If the count is equal to n, we are removing the head node
        if (cnt == n) {
            // Set the new head as the next node
            ListNode newhead = head.next;

            head = null;  // Remove the old head
            return newhead;  // Return the new head
        }

        // Calculate the position of the node to be removed from the start
        int res = cnt - n;

        // Reset the temporary pointer to the head for the second traversal
        temp = head;

        // Traverse the list until we reach the node just before the node to be removed
        while (temp != null) {
            res--;  // Decrement the position counter

            if (res == 0) {
                break;  // Exit the loop when we've reached the node before the target
            }

            temp = temp.next;  // Move to the next node
        }

        // Save the node to be deleted
        ListNode delNode = temp.next;
        // Skip the node to be removed by adjusting pointers
        temp.next = temp.next.next;
 
        // Dereference the deleted node for garbage collection
        delNode = null;

        // Return the updated list's head
        return head;
    }
    */

    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Time Complexity = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // If the linked list is empty, return null
        if (head == null) {
            return null;
        }

        // Initialize two pointers: fastp and slowp
        ListNode fastp = head;  // Fast pointer to traverse the list quickly
        ListNode slowp = head;  // Slow pointer to identify the N-th node from the end

        // Move the fastp pointer N nodes ahead
        for (int i = 0; i < n; i++) {
            fastp = fastp.next;  // Advance fastp N steps ahead
        }

        // If fastp becomes null, it means we need to remove the head node
        if (fastp == null) {
            return head.next;  // Return the new head, which is the next node
        }

        // Move both pointers until fastp reaches the last node
        while (fastp.next != null) {
            fastp = fastp.next;  // Move fastp to the next node
            slowp = slowp.next;  // Move slowp to the next node
        }

        // Now, slowp is just before the N-th node from the end
        ListNode delNode = slowp.next;  // Node to be deleted
        
        slowp.next = slowp.next.next;  // Skip the node to be deleted
        delNode = null;  // Dereference the deleted node for garbage collection

        // Return the head of the modified list
        return head;
    }

}
