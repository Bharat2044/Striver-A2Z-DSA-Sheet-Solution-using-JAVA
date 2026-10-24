// Question Link: https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list


class Solution {
    // // Time Complexity = O(n), Space Complexity = O(1)
    static Node deleteAllOccurOfX(Node head, int k) {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }
        
        // Initialize newHead to track the new head after deletions
        Node newHead = head;
        
        // Iterate through the linked list
        while (head != null) {
            
            // If the current node's data matches 'k', remove the node
            if (head.data == k) {
                Node nextNode = head.next;  // Store the next node
                
                // If it's the head node, update the newHead
                if (head.prev == null) {
                    newHead = nextNode;  // Move the head pointer to the next node
                } 
                
                // If it's the last node, update the previous node's next pointer
                if (nextNode == null) {
                    head.prev.next = null;
                    break;
                }
                
                // Update the previous pointer of the next node
                nextNode.prev = head.prev;
                
                // If the current node is not the first node, update the next pointer of the previous node
                if (head.prev != null) {
                    head.prev.next = nextNode;
                }
                
                // Move the head pointer to the next node after deletion
                head = nextNode;
            } else {
                // If the current node does not match 'k', just move to the next node
                head = head.next;
            }
        }
        
        // Return the new head after all deletions
        return newHead;
    }
}
