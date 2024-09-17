## Introduction to Linked Lists

A **Linked List** is a linear data structure where elements, known as **nodes**, are linked using pointers. Each node contains two parts:
1. **Data**: The value or data that the node holds.
2. **Reference (or pointer)**: A reference to the next node in the sequence (or `null` in the case of the last node).

This is different from arrays, where elements are stored in contiguous memory locations. In a linked list, nodes can be scattered throughout memory, and the reference in each node links them together.

### Structure of a Node in Java

In Java, to represent a node in a linked list, we often use a class. The class typically contains two fields:
- One for storing the data.
- One for storing the reference (or pointer) to the next node.

Let’s go through this step by step.

#### 1. **Defining a Node in Java**

A **node** can be represented using a `class` in Java. This class will typically have:
- A field for the data.
- A field for the reference (or pointer) to the next node.

Here’s how you can define a simple `Node` class in Java:

```java
class Node {
    int data;      // Data field to store the value of the node
    Node next;     // Pointer (reference) to the next node in the list

    // Constructor to initialize the node
    public Node(int data) {
        this.data = data;
        this.next = null;   // Initially, the next node is null (no connection yet)
    }
}
```

- **data**: This stores the value of the node, in this case, an integer (`int`).
- **next**: This is a reference (pointer) to the next `Node` in the linked list. Initially, this is set to `null`, meaning the node doesn’t point to any other node yet.

#### 2. **How Nodes Are Linked Together**

Each node in a linked list points to the next node. A linked list is built by connecting multiple `Node` objects through their `next` pointers.

Here’s how you can link nodes together:

```java
public class LinkedList {
    Node head;  // Head of the list (starting point of the linked list)

    public LinkedList() {
        head = null;   // Initially, the list is empty, so the head is null
    }

    // Method to add a new node at the front of the list
    public void addFront(int data) {
        Node newNode = new Node(data);  // Create a new node with given data
        newNode.next = head;            // Link the new node to the current head
        head = newNode;                 // Move the head to point to the new node
    }

    // Method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
```

#### Explanation:

- **`head`**: This is the first node of the linked list. Initially, it is `null` because the list is empty.
- **`addFront(int data)`**: This method adds a new node at the beginning of the list. A new `Node` is created, its `next` pointer is set to the current `head` (which might be `null` if the list is empty), and then the `head` is updated to point to the new node.
- **`printList()`**: This method prints all nodes in the linked list, starting from the `head` and following the `next` pointers.

#### Example of Using the LinkedList Class:

```java
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFront(10);  // LinkedList: 10 -> null
        list.addFront(20);  // LinkedList: 20 -> 10 -> null
        list.addFront(30);  // LinkedList: 30 -> 20 -> 10 -> null

        list.printList();   // Output: 30 -> 20 -> 10 -> null
    }
}
```

### How the Linked List Works:

1. **Adding a Node**: When a new node is added, its `next` pointer is set to the current `head`, and then the `head` pointer is updated to this new node. This effectively makes the new node the first node in the list.
2. **Traversal**: To print the linked list or perform other operations, we start at the `head` node and follow the `next` pointers until we reach a node whose `next` is `null` (the end of the list).

### Types of Linked Lists

- **Singly Linked List**: Each node points to the next node, and the last node points to `null`. This is what we have described above.
- **Doubly Linked List**: Each node has two pointers: one pointing to the next node and another pointing to the previous node.
- **Circular Linked List**: The last node points back to the first node instead of `null`, forming a circle.

### Key Points:
- Linked lists allow efficient insertions and deletions from the beginning or middle of the list since there's no need to shift elements as in arrays.
- Accessing elements in a linked list requires traversal from the `head`, making random access slower compared to arrays.
