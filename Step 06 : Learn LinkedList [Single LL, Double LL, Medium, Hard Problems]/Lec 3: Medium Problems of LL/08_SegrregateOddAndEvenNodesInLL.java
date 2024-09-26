// Question Link: https://leetcode.com/problems/odd-even-linked-list/description/


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
    public ListNode oddEvenList(ListNode head) {
        // If the list is empty or contains only one element, return the list as it is
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers: 'odd' starts at the first node, 'even' starts at the second node
        ListNode odd = head; // Tracks the last node in the odd-indexed list
        ListNode even = head.next; // Tracks the last node in the even-indexed list
        ListNode temp = even; // Keep track of the head of the even list to connect later

        // Rearrange nodes so that odd nodes come first, followed by even nodes
        while (even != null && even.next != null) {
            // Link the current odd node to the next odd node (which is the next of the current even)
            odd.next = even.next;
            odd = odd.next; // Move the odd pointer forward

            // Link the current even node to the next even node (which is the next of the current odd)
            even.next = odd.next;
            even = even.next; // Move the even pointer forward
        }

        // Connect the last odd node to the head of the even list
        odd.next = temp;

        // Return the re-arranged list
        return head;
    }
}
