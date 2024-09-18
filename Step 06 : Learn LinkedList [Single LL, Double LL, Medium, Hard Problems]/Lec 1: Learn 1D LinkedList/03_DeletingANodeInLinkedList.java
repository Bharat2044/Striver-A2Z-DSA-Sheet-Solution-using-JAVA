// Question Link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1st Approach: Brute Force Approach - Time Complexity = O(1), Space Complexity = O(1)
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode temp = node.next;

        while(temp != null){
            curr.val = temp.val;
        
            if(temp.next == null){
                curr.next = null;
                return;
            }
        
            curr = temp;
            temp = temp.next;
        }
    }

    /*
    // 2nd Approach: Optimal Approach - Time Complexity = O(1), Space Complexity = O(1)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    */
}
