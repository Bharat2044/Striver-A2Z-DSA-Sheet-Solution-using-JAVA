// Question Link: https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-insertion


class Solution {
    // Function to insert a node at the end of the linked list.
    // Time Complexity = O(n), Space Complexity = O(1)
    Node insertAtEnd(Node head, int x) {
    
        // Create a new node with the given value.
        Node newNode = new Node(x);
    
        // If the list is empty, return the new node as the head.
        if (head == null) {
            return newNode;
        }
    
        // Initialize `last` to traverse the list from the head.
        Node last = head;
    
        // Traverse to the last node.
        while (last.next != null) {
            last = last.next;
        }
    
        // Link the new node at the end of the list.
        last.next = newNode;
    
        // Return the head of the list.
        return head; 
    }
}
