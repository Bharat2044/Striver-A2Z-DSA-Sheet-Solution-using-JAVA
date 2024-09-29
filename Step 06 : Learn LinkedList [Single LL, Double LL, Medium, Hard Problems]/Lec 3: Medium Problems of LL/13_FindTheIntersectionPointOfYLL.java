// Question Link: https://leetcode.com/problems/intersection-of-two-linked-lists/description/


/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    // 1st Approach: Brute Force Approach - Time Complexity = O(m * n), Space Complexity = O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp;

        // Iterate through the nodes of the first linked list
        while (headA != null) {
            temp = headB;

            // Iterate through the nodes of the second linked list
            while (temp != null) {
                // If the current nodes are the same, we found the intersection
                if (headA == temp) {
                    return headA;
                }
                temp = temp.next;
            }

            // Move to the next node in the first linked list
            headA = headA.next;
        }

        // No intersection found
        return null;
    }
    */

    /*
    // 2nd Approach: Better Approach(Using HashMap) - Time Complexity = O(m + n), Space Complexity = O(m)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Using a HashMap to store nodes of the first linked list
        HashMap<ListNode, Integer> map = new HashMap<>();

        // Iterate through the nodes of the first linked list and store them in the map
        while (headA != null) {
            map.put(headA, map.getOrDefault(headA, 0) + 1);
            headA = headA.next;
        }

        // Iterate through the nodes of the second linked list
        while (headB != null) {
            // If the current node is in the map, it means we found the intersection
            if (map.containsKey(headB) && map.get(headB) > 0) {
                return headB;
            }
            headB = headB.next;
        }

        // No intersection found
        return null;
    }
    */

    /*
    // 3rd Approach: Optimal Approach(Using Length Difference) - Time Complexity = O(m * n), Space Complexity = O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        int m = 0;

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        // Count the nodes in the first linked list
        while (ptr1 != null) {
            n++;
            ptr1 = ptr1.next;
        }

        // Count the nodes in the second linked list
        while (ptr2 != null) {
            m++;
            ptr2 = ptr2.next;
        }

        int t = Math.abs(n - m);

        // Move the pointer of the longer linked list to make their lengths equal
        if (n > m) {
            while (t > 0) {
                headA = headA.next;
                t--;
            }
        } else {
            while (t > 0) {
                headB = headB.next;
                t--;
            }
        }

        // Iterate through both linked lists until an intersection is found
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // Intersection found
            }
            headA = headA.next;
            headB = headB.next;
        }

        // No intersection found
        return null;
    }
    */

    // 4th Approach: Optimal Approach(Using 2 Pointers) - Time Complexity = O(m * n), Space Complexity = O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // If either head is null, there is no intersection
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize two pointers to traverse both linked lists
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // Continue until both pointers are equal (either at intersection or both null)
        while (temp1 != temp2) {

            // Move each pointer one step ahead
            temp1 = temp1.next;
            temp2 = temp2.next;

            // If both pointers meet at the same node, return that node as the intersection
            if (temp1 == temp2) {
                return temp1;
            }

            // If one pointer reaches the end of the list, move it to the head of the other list
            if (temp1 == null) {
                temp1 = headB;
            }

            // If the other pointer reaches the end of the list, move it to the head of the first list
            if (temp2 == null) {
                temp2 = headA;
            }
        }

        // Return the intersection node, or null if no intersection exists
        return temp1;            
    }
}
