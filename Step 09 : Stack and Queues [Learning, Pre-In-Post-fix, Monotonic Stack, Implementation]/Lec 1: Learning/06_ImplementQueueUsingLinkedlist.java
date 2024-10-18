// Question Link: https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-queue-using-linked-list


class MyQueue {
    // Pointers for the front and rear of the queue
    QueueNode front, rear;

    // Constructor to initialize front and rear as null (empty queue)
    MyQueue() {
        front = null;
        rear = null;
    }

    // Function to push an element into the queue (enqueue operation)
    void push(int a) {
        // Create a new node with the given data
        QueueNode newNode = new QueueNode(a);
        
        // If the queue is empty, both front and rear will point to the new node
        if (rear == null) {
            front = rear = newNode;
        } else {
            // Otherwise, add the new node at the rear and update rear pointer
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Function to pop the front element from the queue (dequeue operation)
    int pop() {
        // If the queue is empty, return -1
        if (front == null) {
            return -1;
        }

        // Store the front node's data
        int poppedData = front.data;

        // Move front to the next node in the list
        front = front.next;

        // If front becomes null, set rear to null as well (queue is empty)
        if (front == null) {
            rear = null;
        }

        // Return the popped data
        return poppedData;
    }
}
