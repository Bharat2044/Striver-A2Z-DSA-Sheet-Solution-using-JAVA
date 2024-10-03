// Question Link: https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list


class Solution {
    /*
    // Function to flatten a linked list
    // 1st Approach: Brute-force solution
    Node flatten(Node root) {
        if (root == null) return null;

        List<Node> nodeList = new ArrayList<>();
        Node current = root;

        // Collect all nodes in the list
        while (current != null) {
            Node bottomList = current;
            
            while (bottomList != null) {
                nodeList.add(bottomList);
                bottomList = bottomList.bottom;
            }
            
            current = current.next;
        }

        // Sort nodes based on data
        nodeList.sort((a, b) -> a.data - b.data);

        // Rebuild the flattened list
        Node newRoot = nodeList.get(0);
        Node temp = newRoot;
        
        for (int i = 1; i < nodeList.size(); i++) {
            temp.bottom = nodeList.get(i);
            temp = temp.bottom;
        }
        
        temp.bottom = null;

        return newRoot;
    }
    */
    
    // Function to merge two sorted linked lists
    Node merge(Node a, Node b) {
        // If list 'a' is empty, return list 'b'
        if (a == null) {
            return b;
        }
        
        // If list 'b' is empty, return list 'a'
        if (b == null) {
            return a;
        }
    
        // To store the merged result
        Node result;  
    
        // If the data in node 'a' is smaller, choose 'a' and merge the remaining part of 'a' with 'b'
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);  // Recursively merge the bottom of 'a' with 'b'
        } else {
            // If the data in node 'b' is smaller, choose 'b' and merge 'a' with the remaining part of 'b'
            result = b;
            result.bottom = merge(a, b.bottom);  // Recursively merge 'a' with the bottom of 'b'
        }
    
        // Return the merged result list
        return result;
    }

    // 2nd Approach: Optimal Solution(Using divide and conquer) 
    // Time Complexity = O(n * log(k)), Space Complexity = O(k)
    Node flatten(Node root) {
        // Base case: if the root is null or there is only one sublist, return the root itself
        if (root == null || root.next == null) {
            return root;
        }
    
        // Recursively flatten the list starting from the next node
        root.next = flatten(root.next);
    
        // Merge the current sublist (starting from root) with the next flattened sublist
        root = merge(root, root.next);
    
        // Return the flattened list
        return root;
    }
}
