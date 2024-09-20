public class DLinkedList {

    // Node class representing a node in the doubly linked list
    public static class Node {
        // Data stored in the node
        public int data;
        
        // Reference to the next node (forward direction)
        public Node next;
        
        // Reference to the previous node (backward direction)
        public Node prev;

        // Constructor for a node with data only (initially no next or prev nodes)
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Method to convert an array into a doubly linked list (DLL)
    private static Node convertArrayToDLL(int[] arr) {
        // If the array is empty, return null
        if (arr.length == 0) {
            return null;
        }

        // Create the head node with the first element
        Node head = new Node(arr[0]);
        Node currentNode = head;

        // Iterate over the array to create nodes and link them
        for (int i = 1; i < arr.length; i++) {
            // Create a new node for the current array element
            Node newNode = new Node(arr[i]);
            // Link the current node's next to the new node
            currentNode.next = newNode;
            
            // Set the new node's prev to the current node
            newNode.prev = currentNode;
            // Move the current node pointer to the new node
            currentNode = newNode;
        }
        
        // Return the head of the DLL
        return head;
    }

    // Method to print the doubly linked list from head to tail
    private static void printList(Node head) {
        Node currentNode = head;
        
        while (currentNode != null) {
            // Print the data of the current node
            System.out.print(currentNode.data + " ");
            // Move to the next node
            currentNode = currentNode.next;
        }
        
        System.out.println(); // Move to the next line after printing the list
    }

    // Method to insert a new node with value 'value' at the tail (end) of the DLL
    private static Node insertAtTail(Node head, int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // If the list is empty, the new node becomes the head
        if (head == null) {
            return newNode;
        }

        // Traverse the list to find the last node
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        // Link the last node's next to the new node
        currentNode.next = newNode;
        
        // Set the new node's prev to the last node
        newNode.prev = currentNode;

        return head; // Return the head of the list (unchanged)
    }

    // Main method to test the DLinkedList functionality
    public static void main(String[] args) {
        // Array to be converted into a doubly linked list
        int[] arr = {12, 5, 6, 8, 4};

        // Convert the array to a doubly linked list (DLL)
        Node head = convertArrayToDLL(arr);

        // Print the initial doubly linked list
        System.out.println("Doubly Linked List Initially:");
        printList(head);

        // Insert a new node with value 10 at the tail of the DLL
        head = insertAtTail(head, 10);

        // Print the doubly linked list after insertion
        System.out.println("Doubly Linked List After Inserting 10 at the Tail:");
        printList(head);
    }
}


/*
| Method                | Time Complexity | Space Complexity |
|-----------------------|-----------------|------------------|
| `convertArrayToDLL`   | O(n)            | O(n)             |
| `printList`           | O(n)            | O(1)             |
| `insertAtTail`        | O(n)            | O(1)             |

- `n` is the size of the input array (for `convertArrayToDLL`) or the size of the doubly linked list (for `printList` and `insertAtTail`).
*/
