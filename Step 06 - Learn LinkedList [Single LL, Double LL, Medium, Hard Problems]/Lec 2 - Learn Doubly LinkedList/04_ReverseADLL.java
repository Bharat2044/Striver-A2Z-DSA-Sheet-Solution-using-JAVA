// Question Link: https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list


// Time Complexity = O(n), Space Complexity = O(1)
    public DLLNode reverseDLL(DLLNode head) {
        
        if (head == null || head.next == null) {
            return head; 
        }
        
        DLLNode curr = head;
        DLLNode prev = null;
        
        while(curr != null){
            DLLNode next = curr.next;
            curr.next = prev;
            curr.prev = next;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
