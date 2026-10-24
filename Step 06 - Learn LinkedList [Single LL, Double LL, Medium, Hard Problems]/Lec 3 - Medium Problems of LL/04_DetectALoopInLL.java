// Question Link: https://leetcode.com/problems/linked-list-cycle/description/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /*
    // 1st Approach: Brute Force Approach (Using HashMap) - Time Complexity = O(n), Space Complexity = O(n)
    public boolean hasCycle(ListNode head) {
        // Initialize a temporary node to traverse the linked list, starting with the head.
        ListNode temp = head;
        
        // Create a HashMap to store visited nodes, using the node as the key.
        Map<ListNode, Integer> nodeMap = new HashMap<>();

        // Loop through the linked list until reaching the end (temp becomes null).
        while (temp != null) {
            // Check if the current node has already been visited (exists in the HashMap).
            if (nodeMap.containsKey(temp)) {
                // If it has been visited, a cycle is detected; return true.
                return true;
            }

            // If not visited, add the current node to the HashMap.
            nodeMap.put(temp, 1);

            // Move to the next node in the linked list.
            temp = temp.next;
        }

        // If the end of the list is reached without finding a cycle, return false.
        return false;
    }
    */

    // 2nd Approach: Optimal Approach (Using 2 Pointers) - Time Complexity = O(n), Space Complexity = O(1)
    public boolean hasCycle(ListNode head) {
        // If the list is empty or has only one node, no cycle can exist.
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers, slow moves one step at a time, fast moves two steps at a time.
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with the two pointers.
        while (fast != null && fast.next != null) {
            // Move slow by one step.
            slow = slow.next;

            // Move fast by two steps.
            fast = fast.next.next;

            // If slow and fast meet, a cycle is detected.
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end of the list, no cycle exists.
        return false;
    }
}
