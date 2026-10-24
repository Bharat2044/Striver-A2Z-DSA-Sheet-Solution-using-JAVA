// Question Link: https://leetcode.com/problems/middle-of-the-linked-list/description/


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
    // 1st Approach: Brute Force Approach - Time Complexity = O(n), SPace Complexity = O(1)
    public ListNode middleNode(ListNode head) {

        // Check if the head is the only node in the list
        if (head.next == null) {
            return head; // If yes, return the head (the middle node)
        }

        // Initialize a temporary node to traverse the list
        ListNode temp = head;

        // Initialize a counter to count the total number of nodes
        int totalNodeCount = 0;
        
        // Traverse the list to count the number of nodes
        while (temp.next != null) {
            temp = temp.next; // Move to the next node
            totalNodeCount++; // Increment the counter
        }

        // Calculate the index of the middle node
        totalNodeCount = (totalNodeCount + 1) / 2;

        // Move the head pointer to the middle node
        while (totalNodeCount > 0) {
            head = head.next; // Move to the next node
            totalNodeCount--; // Decrement the count
        }

        // Return the middle node
        return head; 
    }
    */


    // 2st Approach: Optimal Approach - Time Complexity = O(n), SPace Complexity = O(1)
    public ListNode middleNode(ListNode head) {
    
        // Initialize slow and fast pointers at the head of the list
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list: the fast pointer moves two steps, and the slow pointer moves one step
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one node
            fast = fast.next.next; // Move fast pointer by two nodes
        }
        
        // When the fast pointer reaches the end, the slow pointer will be at the middle
        return slow;
    }
}
