// Question Link: https://leetcode.com/problems/add-two-numbers/description/


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
    // Time Complexity = O(max(m, n)), Space Complexity = O(max(m, n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node to simplify the addition logic
        ListNode dummy = new ListNode();
        
        // Use a temporary pointer 'temp' to iterate through the result list
        ListNode temp = dummy;
        
        // Variable to store carry value during addition
        int carry = 0;

        // Loop continues until both linked lists are fully traversed or there's a carry remaining
        while (l1 != null || l2 != null || carry == 1) {
            // Initialize sum for the current digit
            int sum = 0;

            // If l1 is not null, add its value to sum and move to the next node
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // If l2 is not null, add its value to sum and move to the next node
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Add any carry from the previous digit's sum
            sum += carry;
           
            // Calculate new carry for the next digit (integer division by 10)
            carry = sum / 10;

            // Create a new node for the current digit (sum % 10) and link it to the result
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            
            // Move the temp pointer to the next position
            temp = temp.next;
        }

        // Return the head of the resulting list, skipping the dummy node
        return dummy.next;
    }
}
