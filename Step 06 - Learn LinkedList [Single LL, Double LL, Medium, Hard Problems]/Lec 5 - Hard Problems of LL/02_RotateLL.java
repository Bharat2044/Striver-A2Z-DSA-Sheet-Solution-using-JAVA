// Question Link: https://leetcode.com/problems/rotate-list/


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
    public ListNode rotateRight(ListNode head, int k) {
        
        // if the list is empty, has only one node, or no rotation is needed (k == 0)
        if (head == null || head.next == null || k == 0) {
            return head;  // Return the list as-is
        }

        // Step 1: Calculate the length of the linked list
        int length = 1;  // Initialize length to 1 because we already know there's at least one node
        ListNode temp = head;

        // Traverse the list to find the last node and count the total number of nodes
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Connect the last node to the head to make the list circular
        temp.next = head;  // This creates a cycle (a circular linked list)

        // Step 3: Adjust k to ensure it's within the bounds of the list length
        // If k is larger than the length of the list, we only need to rotate by (k % length)
        k = k % length;

        // Step 4: Calculate the new starting point of the list after rotation
        // We want to find the (length - k)-th node to break the cycle
        k = length - k;

        // Step 5: Move temp pointer to the new tail (the (length - k)-th node)
        while (k-- > 0) {
            temp = temp.next;
        }

        // Step 6: Set the new head to be the node after the new tail
        head = temp.next;

        // Break the cycle by setting the next pointer of the new tail to null
        temp.next = null;

        // Return the new head of the rotated list
        return head;
    }
}
