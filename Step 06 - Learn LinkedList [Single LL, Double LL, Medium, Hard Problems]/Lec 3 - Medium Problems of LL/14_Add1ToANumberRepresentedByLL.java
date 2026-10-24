// Question Link: https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list


class Solution {
    
    // Time Complexity = O(n), Space Complexity = O(1)
    public Node addOne(Node head) {
        
        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        Node prev = null;  // This will track the last node that is not equal to 9
        Node cur = head;   // Pointer to traverse the linked list

        // Traverse the linked list to find the rightmost node that is not 9
        while (cur != null) {
            if (cur.data < 9) {
                prev = cur;  // Update prev to the current node if its value is less than 9
            }
            
            cur = cur.next;  // Move to the next node
        }
        
        // If prev is still null, it means all nodes in the list contain 9
        if (prev == null) {
            
            // Create a new node with value 1, as adding 1 to all 9s will create a new leading 1
            Node newNode = new Node(1);
            newNode.next = head;  // Set newNode as the new head, and link it to the original head
            
            head = newNode;       // Update head to point to the new node
            cur = head.next;      // Set cur to the node after the new head
            
            // Set all subsequent nodes' values to 0
            while (cur != null) {
                cur.data = 0;
                cur = cur.next;
            }
            
            return head;  // Return the modified head of the list
        }

        // Increment the data of the last non-9 node by 1
        prev.data = prev.data + 1;
        
        // Set all subsequent nodes' values to 0 since adding 1 causes a carry to these nodes
        cur = prev.next;
        while (cur != null) {
            cur.data = 0;
            cur = cur.next;
        }

        return head;  // Return the modified head of the list
    }
}
