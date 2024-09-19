// Question Link: https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-linked-list-1664434326


class Solution {
    // Time Complexity = O(n), Space Complexity = O(1)
    static boolean searchKey(int n, Node head, int key) {
        Node temp = head;
        
        while (temp != null) {
            
            if (temp.data == key) {
                return true;
            }
            
            temp = temp.next;
        }
        
        return false;
    }
}
