// Question Link: https://geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop


class Solution {
    /*
    // 1st Approach: Brute Force Approach(Using HashMap) - Time Complexity = O(n), Space Complexity = O(n)
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        
        // Create a HashMap to store each node and the time (or step) at which it was visited.
        Map<Node, Integer> visitedNodes = new HashMap<>();
        
        // Initialize temp with head to start traversal from the beginning.
        Node temp = head;
        
        // Initialize timer to count the number of steps or iterations.
        int timer = 0;
    
        // Traverse the linked list until we reach the end (i.e., temp is null).
        while (temp != null) {
    
            // If the current node has been visited before, a loop is detected.
            if (visitedNodes.containsKey(temp)) {
                
                // Calculate the loop length by subtracting the previous visit time from the current time.
                int loopLength = timer - visitedNodes.get(temp);
                
                // Return the length of the loop.
                return loopLength;
            }
    
            // If the node has not been visited, store the current node and the current time.
            visitedNodes.put(temp, timer);
            
            // Move to the next node in the list.
            temp = temp.next;
            
            // Increment the timer (step counter).
            timer++;
        }
    
        // If no loop is found, return 0 to indicate there is no loop in the linked list.
        return 0;
    }
    */

    // 2nd Approach: Optimal Approach(Using 2 Pointers) - Time Complexity = O(n), Space Complexity = O(1)
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        
        // Initialize two pointers, slow and fast, both starting at the head.
        Node slowPointer = head;
        Node fastPointer = head;
    
        // Phase 1: Detect the presence of a loop using fast and slow pointers.
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            // Move the slow pointer by one step.
            slowPointer = slowPointer.next;
            
            // Move the fast pointer by two steps.
            fastPointer = fastPointer.next.next;
    
            // If slowPointer and fastPointer meet, a loop is detected.
            if (slowPointer == fastPointer) {
                // Phase 2: Calculate the length of the loop.
                return countLoopLength(slowPointer);
            }
        }
    
        // If no loop is found, return 0.
        return 0;
    }
    
    // Helper method to count the number of nodes in the loop.
    private int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;
        int loopLength = 1;
    
        // Move the pointer one step at a time until it meets the meeting point again.
        while (temp.next != meetingPoint) {
            temp = temp.next;
            loopLength++;
        }
    
        return loopLength;
    }
}
