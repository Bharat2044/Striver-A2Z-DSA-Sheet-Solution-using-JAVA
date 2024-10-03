// Question Link: https://leetcode.com/problems/copy-list-with-random-pointer/description/


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
    // 1st Approach: Brute Force Solution - Time Complexity = O(n), Space Complexity = O(n)
    public Node copyRandomList(Node head) {
        // If the original list is empty, return null (nothing to copy)
        if (head == null) {
            return null;
        }

        // Step 1: Create a hashmap to map original nodes to their copied counterparts
        Map<Node, Node> nodeMap = new HashMap<>();

        // Step 2: Create new nodes (copies) and map them to the original ones
        Node current = head;  // Start traversing the original list
        
        // Traverse the original list and create a copy of each node
        while (current != null) {
            nodeMap.put(current, new Node(current.val));  // Create a new node (copy) and map it to the original
            current = current.next;  // Move to the next node in the original list
        }

        // Step 3: Set the next and random pointers for the copied nodes
        current = head;  // Reset 'current' to the head to start another traversal

        // Traverse the original list again to set the next and random pointers for the copied nodes
        while (current != null) {
            Node copy = nodeMap.get(current);  // Get the copy of the current node
            copy.next = nodeMap.get(current.next);  // Set the 'next' pointer of the copied node
            copy.random = nodeMap.get(current.random);  // Set the 'random' pointer of the copied node
            current = current.next;  // Move to the next node in the original list
        }

        // Step 4: Return the head of the copied list
        return nodeMap.get(head);  // Return the copy of the original head node
    }
    */

    // 2nd Approach: Optimal Solution - Time Complexity = O(n), Space Complexity = O(1)
    public Node copyRandomList(Node head) {
        // If the original list is empty, return null (nothing to copy)
        if (head == null) {
            return null;
        }

        // Step 1: Insert cloned nodes right next to the original nodes
        Node current = head;  // Initialize current to the head of the original list
        
        // Traverse the list and insert a clone of each node right after the original node
        while (current != null) {
            Node copy = new Node(current.val);  // Create a new node (clone) with the same value as the original
            copy.next = current.next;  // Set the next of the clone to the next of the current original node
            
            current.next = copy;  // Insert the clone right after the original node
            current = copy.next;  // Move to the next original node (skipping the clone)
        }

        // Step 2: Assign the random pointers for the cloned nodes
        current = head;  // Reset 'current' to the head of the original list
        
        // Traverse the list again to set the random pointers of the cloned nodes
        while (current != null) {
            if (current.random != null) {
                // Set the random pointer of the clone to the clone of the original node's random pointer
                current.next.random = current.random.next;
            }
            
            current = current.next.next;  // Move to the next original node (skipping the clone)
        }

        // Step 3: Separate the cloned list from the original list
        current = head;  // Reset 'current' to the head of the original list
        
        Node newHead = head.next;  // The head of the cloned list (first clone node)
        Node copyCurrent = newHead;  // Pointer to traverse the cloned list
        
        // Traverse the list to restore the original list and extract the cloned list
        while (current != null) {
            // Restore the next pointer of the original node
            current.next = current.next.next;  

            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;  // Set the next pointer of the clone to the next clone node
            }
            
            current = current.next;  // Move to the next original node
            copyCurrent = copyCurrent.next;  // Move to the next cloned node
        }

        // Step 4: Return the head of the copied list
        return newHead;  // Return the head of the cloned list
    }
}
