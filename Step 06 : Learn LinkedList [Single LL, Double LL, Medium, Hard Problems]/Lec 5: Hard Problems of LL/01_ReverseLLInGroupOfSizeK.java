// Question Link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/


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

    // Time Complexity: O(N), Space Complexity: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {

        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode();
        dummy.next = head;

        // Declare three pointers: prev, curr, and next
        ListNode prev = dummy;  // prev initially points to the dummy node
        ListNode curr = head;   // curr points to the current node being processed (initially head)
        ListNode next = curr != null ? curr.next : null;  // next points to the node after curr

        int count = 0;  // Counter to determine the length of the list

        // First, determine the length of the linked list
        while (curr != null) {
            count++;  // Increment the count for each node
            curr = curr.next;  // Move curr to the next node
        }

        // Reset curr to point to the head of the list again
        curr = head;

        // Loop through the list and reverse every group of k nodes
        // Continue as long as the number of remaining nodes is greater than or equal to k
        while (count >= k) {
            // Reset curr and next for the new group of k nodes to be reversed
            curr = prev.next;  // curr points to the first node of the current group
            next = curr.next;  // next points to the second node of the current group

            // Reverse the k nodes in the current group
            for (int i = 1; i < k; i++) {
                curr.next = next.next;  // Point the current node to the node after next (removing next from its position)
                next.next = prev.next;  // Point next to the first node of the group, effectively reversing the link

                prev.next = next;  // Move next to the front of the group by pointing prev to it
                next = curr.next;  // Move next to the next node in the list to continue the reversal
            }

            // After reversing the group, move prev to the last node in the reversed group
            prev = curr;

            // Reduce the count by k as we've processed a group of k nodes
            count -= k;
        }

        // Return the new head of the list (dummy.next points to the new head after reversal)
        return dummy.next;
    }
}
