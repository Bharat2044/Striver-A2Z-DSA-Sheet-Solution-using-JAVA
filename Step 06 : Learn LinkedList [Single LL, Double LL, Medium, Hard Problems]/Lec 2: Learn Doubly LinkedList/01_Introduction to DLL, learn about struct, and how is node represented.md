## Introduction to Doubly Linked List (DLL) in Java

A **Doubly Linked List (DLL)** is a type of linked list in which each node contains a data part and two pointers, `prev` and `next`. The `prev` pointer points to the previous node in the list, while the `next` pointer points to the next node. This structure allows traversal of the list in both directions (forward and backward), unlike a **Singly Linked List**, where traversal is only possible in one direction.

#### Key Properties of Doubly Linked List:
1. **Bidirectional Traversal**: Each node can be accessed from both the next node and the previous node.
2. **Dynamic Size**: The size of the list can grow or shrink dynamically as elements are added or removed.
3. **Extra Memory Requirement**: Each node needs additional memory for storing the `prev` pointer, making the memory overhead higher than that of a singly linked list.

### Structuring a Node in DLL

A **node** in a doubly linked list typically contains three parts:
1. **Data**: This holds the value or data of the node.
2. **Prev Pointer**: This pointer holds the reference to the previous node in the list.
3. **Next Pointer**: This pointer holds the reference to the next node in the list.

#### Representing a Node in Java:

In Java, we can represent each node as an object of a `Node` class. Each node will contain three fields:
- A data field of a particular type (could be `int`, `String`, or any other data type).
- A `Node` reference for the previous node (`prev`).
- A `Node` reference for the next node (`next`).

Here’s how we can represent a **Node** in a Doubly Linked List in Java:

```java
// Class representing a node in a doubly linked list
class Node {
    int data;       // Data stored in the node
    Node prev;      // Pointer to the previous node
    Node next;      // Pointer to the next node

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;   // Assign the data
        this.prev = null;   // Initially, prev is null
        this.next = null;   // Initially, next is null
    }
}
```

### Explanation:
- **`data`**: Holds the data value of the node.
- **`prev`**: This pointer holds the reference to the previous node in the list (or `null` if the node is the head of the list).
- **`next`**: This pointer holds the reference to the next node in the list (or `null` if the node is the tail of the list).
  
The constructor `Node(int data)` initializes the node with a value, while `prev` and `next` are initially set to `null`.

### Full Implementation of a Doubly Linked List

Now that we have the node representation, let’s see how a doubly linked list can be constructed using these nodes. We need a **DoublyLinkedList** class to manage the nodes.

```java
// Class representing the Doubly Linked List
class DoublyLinkedList {
    Node head; // Head (first node) of the list

    // Method to add a node at the front of the list
    public void addFront(int data) {
        Node newNode = new Node(data);  // Create a new node
        if (head == null) {
            head = newNode;             // If list is empty, new node becomes the head
        } else {
            newNode.next = head;        // Point the new node's next to the current head
            head.prev = newNode;        // Point the current head's prev to the new node
            head = newNode;             // Update head to the new node
        }
    }

    // Method to add a node at the end of the list
    public void addEnd(int data) {
        Node newNode = new Node(data);  // Create a new node
        if (head == null) {
            head = newNode;             // If list is empty, new node becomes the head
        } else {
            Node temp = head;           // Temporary node to traverse to the end
            while (temp.next != null) {
                temp = temp.next;       // Move to the next node
            }
            temp.next = newNode;        // Point the last node's next to the new node
            newNode.prev = temp;        // Point the new node's prev to the last node
        }
    }

    // Method to display the list from the head to the end
    public void displayForward() {
        Node temp = head;               // Start from the head
        while (temp != null) {
            System.out.print(temp.data + " "); // Print the data
            temp = temp.next;           // Move to the next node
        }
        System.out.println();
    }

    // Method to display the list from the end to the head
    public void displayBackward() {
        if (head == null) return;        // Empty list, nothing to display

        Node temp = head;                // Temporary node to traverse the list
        while (temp.next != null) {      // Move to the last node
            temp = temp.next;
        }
        // Now temp is the last node
        while (temp != null) {
            System.out.print(temp.data + " "); // Print the data
            temp = temp.prev;           // Move to the previous node
        }
        System.out.println();
    }
}
```

### Explanation:
1. **Adding a Node at the Front**: In the `addFront` method, a new node is created and linked at the front of the list. The previous head node is updated to point back to the new node.
2. **Adding a Node at the End**: In the `addEnd` method, the new node is added to the end of the list. We traverse to the last node and link the new node accordingly.
3. **Display Methods**:
   - `displayForward` prints the list starting from the head node to the end.
   - `displayBackward` traverses to the last node and prints the list in reverse order using the `prev` pointers.

### Example Usage:
```java
public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFront(10);
        dll.addFront(20);
        dll.addEnd(30);
        
        System.out.println("Forward Traversal:");
        dll.displayForward();  // Output: 20 10 30

        System.out.println("Backward Traversal:");
        dll.displayBackward(); // Output: 30 10 20
    }
}
```

### Explanation:
- We first add nodes to the list using both `addFront` and `addEnd` methods.
- The `displayForward` and `displayBackward` methods demonstrate how to traverse and display the list in both directions.
