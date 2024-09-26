// Question Link: https://leetcode.com/problems/palindrome-linked-list/description/


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
    // 1st Approach: Brute Force Approac(Using Stack) - Time Complexity = O(n), Space Complexity = O(n)
    public boolean isPalindrome(ListNode head) {
        // Create a stack to store the values of the linked list nodes
        Stack<Integer> st = new Stack<>();

        // Initialize a temporary pointer to traverse the linked list
        ListNode temp = head;

        // Traverse the entire linked list and push each node's value onto the stack
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next; // Move to the next node
        }

        // Reset the temporary pointer to the head of the list for a second traversal
        temp = head;

        // Traverse the list again and compare each node's value with the top value of the stack
        while (temp != null) {
            // If the current node's value does not match the stack's top value, it's not a palindrome
            if (temp.val != st.peek()) {
                return false;
            }

            // Pop the top value from the stack and move to the next node
            st.pop();
            temp = temp.next;
        }

        // If all values matched, the list is a palindrome
        return true;
    }
    */
    
    // 2nd Approach: Brute Force Approac(Using Stack) - Time Complexity = O(n), Space Complexity = O(1)
    public boolean isPalindrome(ListNode head) {
        // If the list is empty or contains only one element, it's automatically a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head; // Slow pointer to find the middle of the list
        ListNode fast = head; // Fast pointer moves twice as fast to reach the end while slow reaches the middle

        // Move fast pointer 2 steps and slow pointer 1 step at a time
        while (fast != null && fast.next != null) {
            slow = slow.next; // Slow pointer moves one step
            fast = fast.next.next; // Fast pointer moves two steps
        }

        // Step 2: Reverse the second half of the linked list starting from the middle
        ListNode secondHalfStart = reverseList(slow); // Reverse the second half of the list
        ListNode reversedHalf = secondHalfStart; // Store the head of the reversed half for restoration later

        // Step 3: Compare the first half and the reversed second half node by node
        ListNode firstHalfStart = head; // Pointer to traverse the first half of the list
        while (secondHalfStart != null) {
            // If the values don't match, it's not a palindrome
            if (firstHalfStart.val != secondHalfStart.val) {
                return false;
            }

            firstHalfStart = firstHalfStart.next; // Move to the next node in the first half
            secondHalfStart = secondHalfStart.next; // Move to the next node in the second half
        }

        // Step 4: Restore the original order of the second half (optional but recommended)
        reverseList(reversedHalf); // Reverse the second half back to its original state

        // If all nodes matched, the linked list is a palindrome
        return true;
    }

    // Helper method to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize previous pointer to null for the reversed list
        ListNode current = head; // Start with the current node as the head of the list

        // Traverse the list and reverse the links between nodes
        while (current != null) {
            
            ListNode nextNode = current.next; // Store the next node temporarily
            current.next = prev; // Reverse the current node's next pointer to point to the previous node
            
            prev = current; // Move the previous pointer to the current node
            current = nextNode; // Move to the next node in the original list
        }

        return prev; // Return the new head of the reversed list
    }
}
