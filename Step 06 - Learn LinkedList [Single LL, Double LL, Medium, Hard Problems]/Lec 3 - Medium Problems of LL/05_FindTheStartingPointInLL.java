// Question Link: https://leetcode.com/problems/linked-list-cycle-ii/description/


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
    public ListNode detectCycle(ListNode head) {
        // Initialize a pointer starting from the head node
        ListNode temp = head;
        
        // Create a HashMap to track visited nodes. The key is the node, and the value is just a placeholder (not used)
        Map<ListNode, Integer> nodeMap = new HashMap<>();

        // Traverse the linked list until the end (null) is reached
        while (temp != null) {
            // Check if the current node has been visited (exists in the map)
            if (nodeMap.containsKey(temp)) {
                // If the node is found in the map, it means a cycle exists. Return the node where the cycle begins
                return temp;
            }

            // Mark the current node as visited by adding it to the map
            nodeMap.put(temp, 1);

            // Move to the next node in the list
            temp = temp.next;
        }

        // If no cycle is detected, return null
        return null;
    }
    */

    // 2nd Approach: Optimal Approach (Using 2 Pointers) - Time Complexity = O(n), Space Complexity = O(1)
    public ListNode detectCycle(ListNode head) {
    
        // Initialize two pointers, slow and fast, both starting from the head
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list to find if there is a cycle
        while (fast != null && fast.next != null) {
            // Move slow pointer by one step
            slow = slow.next;
            
            // Move fast pointer by two steps
            fast = fast.next.next;

            // If slow and fast pointers meet, it means there is a cycle
            if (slow == fast) {
                // Reset the slow pointer to the head of the list
                slow = head;

                // Move both pointers one step at a time until they meet again
                // The meeting point will be the start of the cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the node where the cycle starts
                return slow;
            }
        }

        // If no cycle is found, return null
        return null;
    }
}
