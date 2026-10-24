// Question Link: https://leetcode.com/problems/lru-cache/description/


class LRUCache {
    
    // Define a Node class to store key, value, and pointers to previous and next nodes
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        // Constructor to initialize a new node with key and value
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // Initialize head and tail dummy nodes for LRU Cache boundaries
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap; // Store the capacity of the cache
    
    // Map to store key-to-node mappings for O(1) access
    HashMap<Integer, Node> m = new HashMap<>();

    // Constructor to initialize LRU cache with a given capacity
    public LRUCache(int capacity) {
        cap = capacity; // Set the cache capacity
        head.next = tail; // Link head to tail initially
        tail.prev = head; // Link tail to head initially
    }

    // Function to add a new node right after head (most recently used position)
    private void addNode(Node newnode) {
        Node temp = head.next; // Store reference to the first node

        newnode.next = temp; // Set newnode's next to the current first node
        newnode.prev = head; // Set newnode's prev to head

        head.next = newnode; // Update head's next to newnode
        temp.prev = newnode; // Update first node's previous to newnode
    }

    // Function to delete a node from its current position
    private void deleteNode(Node delnode) {
        Node prevv = delnode.prev; // Reference to node before delnode
        Node nextt = delnode.next; // Reference to node after delnode

        prevv.next = nextt; // Update previous node's next to skip delnode
        nextt.prev = prevv; // Update next node's prev to skip delnode
    }

    // Function to get the value of a key, updating it as most recently used
    public int get(int key) {
        
        // Check if key exists
        if (m.containsKey(key)) {
            Node resNode = m.get(key); // Retrieve the node
            int ans = resNode.val; // Store the value to return

            m.remove(key); // Remove key from map (for reordering)
            deleteNode(resNode); // Remove node from its current position
            addNode(resNode); // Add node back at the most recent position

            m.put(key, head.next); // Update map with the new most recent position
            return ans; // Return the node's value
        }
        
        return -1; // If key doesn't exist, return -1
    }

    // Function to add or update a key-value pair
    public void put(int key, int value) {
        if (m.containsKey(key)) { // Check if key exists
            Node curr = m.get(key); // Get the existing node
            m.remove(key); // Remove it from map
            deleteNode(curr); // Delete it from current position
        }

        if (m.size() == cap) { // If cache is at capacity
            m.remove(tail.prev.key); // Remove least recently used item from map
            deleteNode(tail.prev); // Delete it from the linked list
        }

        addNode(new Node(key, value)); // Add new node at most recent position
        m.put(key, head.next); // Update map with the new node's position
    }
}
