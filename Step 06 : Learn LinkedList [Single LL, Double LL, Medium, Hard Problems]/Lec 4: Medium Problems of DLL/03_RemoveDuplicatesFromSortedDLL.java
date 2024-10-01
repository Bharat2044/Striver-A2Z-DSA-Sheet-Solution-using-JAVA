// Question Link: https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicates-from-a-sorted-doubly-linked-list


class Solution{
    
    // Time Complexity = O(n), Space Complexity = O(1)
    Node removeDuplicates(Node head) {
        // Initialize a temporary pointer 'temp' to traverse the list starting from the head
        Node temp = head;
    
        // Initialize 'back' as null to keep track of the previous node
        Node back = null;
    
        // Loop through the list until the second last node
        while (temp.next != null) {
            
            // Check if the current node's data is equal to the next node's data
            if (temp.data == temp.next.data) {
                // If they are equal, bypass the next node by updating 'temp.next' to skip the duplicate
                temp.next = temp.next.next;
            } else {
                // If the values are not equal, update 'back' to the current node
                back = temp;
                
                temp = temp.next; // Move 'temp' to the next node
                temp.prev = back; // Update 'temp.prev' to point to 'back' to maintain the doubly linked list structure
            }
        }
    
        // Return the head of the modified list
        return head;
    }
}
