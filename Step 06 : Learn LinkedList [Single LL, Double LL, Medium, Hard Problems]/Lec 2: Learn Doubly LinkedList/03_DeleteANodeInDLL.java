// Question Link: https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list


class Solution {
    
    public Node deleteNode(Node head, int x) {
        // code here
        Node temp = head;
        
        for (int i = 1; i < x; i++){
            temp = temp.next;
        }
        
        if (temp.prev == null){
            head = temp.next;
            return head;
        } else {
            temp.prev.next = temp.next;
        }
        
        return head;
    }
}
