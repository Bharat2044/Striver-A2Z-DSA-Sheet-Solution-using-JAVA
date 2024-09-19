// Question Link: https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-nodes-of-linked-list


class Solution {
    // Function to count nodes of a linked list.
    // Time Complexity = O(n), Space Complexity = O(1)
    public int getCount(Node head) {
        
        Node temp = head;
        int count = 0;
        
        while (temp != null) {
            
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}
