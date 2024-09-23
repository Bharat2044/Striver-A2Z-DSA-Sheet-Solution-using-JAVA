// Question Link: https://leetcode.com/problems/reverse-linked-list/description/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    // 1st Approach: Brute Force Approach (Using Stack) - Time Complexity = O(n), Space Complexity = O(n)
    public ListNode reverseList(ListNode head) {
        // Initialize a pointer to traverse the linked list starting from the head
        ListNode temp = head;

        // Initialize a stack to store the values of the nodes
        Stack<Integer> stack = new Stack<>();

        // Traverse the list and push each node's value onto the stack
        while (temp != null) {
            stack.push(temp.val);  // Push current node's value to stack
            temp = temp.next;  // Move to the next node
        }

        // Reset the temp pointer to start from the head again
        temp = head;

        // Pop values from the stack and assign them back to the list in reverse order
        while (temp != null) {
            temp.val = stack.pop();  // Pop the top value from the stack and assign it to the current node
            temp = temp.next;  // Move to the next node
        }

        // Return the modified list which is now reversed
        return head;
    }
    */
    
    /*
    // 2nd Approach: Better Approach (Using Recursion) - Time Complexity = O(n), Space Complexity = O(n)
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has one node, return head as it is already reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Reverse the current node's pointer
        head.next.next = head;  // Make the next node point back to the current node
        head.next = null;       // Set current node's next to null, as it will be the new tail

        // Return the new head of the reversed list
        return newHead;
    }
    */

    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    public ListNode reverseList(ListNode head) {
        // Initialize prev to null (this will be the new tail after reversal)
        ListNode prev = null;

        // Traverse through the list
        while (head != null) {
            // Temporarily store the next node
            ListNode nextNode = head.next;

            // Reverse the current node's pointer to point to the previous node
            head.next = prev;

            // Move prev and head one step forward
            prev = head;      // prev becomes the current node
            head = nextNode;  // head moves to the next node in the original list
        }

        // prev will now be the new head of the reversed list
        return prev;
    }
}
