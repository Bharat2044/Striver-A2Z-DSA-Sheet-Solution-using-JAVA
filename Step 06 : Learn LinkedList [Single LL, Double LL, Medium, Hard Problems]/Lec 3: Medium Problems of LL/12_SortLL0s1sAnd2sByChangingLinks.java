// Question Link: https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it


class Solution {
    /*
    // 1st Approach: Brute Force Approach - Time Complexity = O(n * log(n)), Space Complexity = O(n)
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // Step 1: Create a list to store the data values from the linked list
        List<Integer> list = new ArrayList<>();
        
        // Step 2: Traverse the linked list and add the node values to the list
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);  // Add the current node's data to the list
            temp = temp.next;     // Move to the next node
        }
        
        // Step 3: Sort the ArrayList in ascending order
        Collections.sort(list);  // Sort the list which will arrange the values as 0s, 1s, and 2s
        
        // Step 4: Create a new linked list from the sorted ArrayList
        // Initialize the new head of the linked list with the first element of the sorted list
        Node newHead = new Node(list.get(0));
        Node curr = newHead;  // Pointer to traverse and build the new list
        
        // Step 5: Construct the new linked list using the sorted list elements
        for (int i = 1; i < list.size(); i++) {
            Node n = new Node(list.get(i));  // Create a new node for each sorted element
            curr.next = n;  // Link the current node to the new node
            curr = curr.next;  // Move the current pointer to the next node
        }
        
        // Return the head of the newly created sorted linked list
        return newHead;
    }
    */

    /*
    // 2nd Approach: Better Approach - Time Complexity = O(n), Space Complexity = O(1)
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // Initialize counters to store the occurrences of 0s, 1s, and 2s
        int count0 = 0, count1 = 0, count2 = 0;
        
        // Create a temporary pointer to traverse the linked list
        Node temp = head;
    
        // First pass: Count the occurrences of 0s, 1s, and 2s in the list
        while (temp != null) {
            if (temp.data == 0) count0++;  // Increment count0 if the node's data is 0
            else if (temp.data == 1) count1++;  // Increment count1 if the node's data is 1
            else if (temp.data == 2) count2++;  // Increment count2 if the node's data is 2
            temp = temp.next;  // Move to the next node
        }
    
        // Reset the temporary pointer to the head to reconstruct the list
        temp = head;
    
        // Second pass: Update the linked list by placing 0s first, then 1s, and finally 2s
        while (count0 > 0) {
            temp.data = 0;  // Assign 0 to the current node
            temp = temp.next;  // Move to the next node
            count0--;  // Decrease the count of 0s
        }
        
        while (count1 > 0) {
            temp.data = 1;  // Assign 1 to the current node
            temp = temp.next;  // Move to the next node
            count1--;  // Decrease the count of 1s
        }
        
        while (count2 > 0) {
            temp.data = 2;  // Assign 2 to the current node
            temp = temp.next;  // Move to the next node
            count2--;  // Decrease the count of 2s
        }
    
        // Return the head of the modified (segregated) linked list
        return head;
    }
    */

    // 3rd Approach: Optimal Approach - Time Complexity = O(n), Space Complexity = O(1)
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // Dummy heads for 0s, 1s, and 2s lists
        Node zeroHead = new Node(0);  // Dummy head for the list of 0s
        Node oneHead = new Node(0);   // Dummy head for the list of 1s
        Node twoHead = new Node(0);   // Dummy head for the list of 2s
    
        // Pointers to the current end of each list
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
    
        // Traverse the original list and partition nodes into three lists
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;  // Append to the list of 0s
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;  // Append to the list of 1s
                one = one.next;
            } else {
                two.next = temp;  // Append to the list of 2s
                two = two.next;
            }
            temp = temp.next;  // Move to the next node
        }
    
        // Now combine the three lists
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;  // Connect 0s to 1s (or directly to 2s if no 1s)
        one.next = twoHead.next;  // Connect 1s to 2s
        two.next = null;  // End the list after 2s
    
        // Return the head of the new list (starting from the 0s list, skipping the dummy node)
        return zeroHead.next;
    }
}
