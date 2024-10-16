// Question Link: https://www.geeksforgeeks.org/problems/implement-queue-using-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-queue-using-array



class MyQueue {

    int front, rear;        // Pointers to track the front and rear of the queue
	int arr[] = new int[100005]; // Array to store elements of the queue, size set to 100005

    // Constructor to initialize the queue
    MyQueue() {
		front = 0; // Initialize front pointer to 0
		rear = 0;  // Initialize rear pointer to 0
	}
	
	// Function to push an element x into the queue.
	void push(int x) {
	    // Insert the element at the rear position
        arr[rear] = x;
        rear++; // Move rear pointer to the next empty position
	} 

    // Function to pop an element from the queue and return that element.
	int pop() {
		// Check if the queue is empty (when front equals rear)
        if(front == rear) {
            return -1; // Return -1 if the queue is empty
        }

        // Store the front element to return later
        int temp = arr[front];
        front++; // Move the front pointer to the next element
        
        return temp; // Return the popped element
	} 
}
