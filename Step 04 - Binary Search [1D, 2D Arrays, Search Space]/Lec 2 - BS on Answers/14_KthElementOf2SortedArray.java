// Question Link: https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array


class Solution {
    /*
    // 1st Approach: Brute Force Approach
    public long kthElement(int k, int arr1[], int arr2[]) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int num : arr1)  
            al.add(num);
            
        for(int num : arr2)  
            al.add(num);
            
        Collections.sort(al);  
        
        return al.get(k - 1);
    }
    */
    
    // 2nd Approach: Optimal Approach (Using Binary Search) - Time Complexity = O(log(min(m, n))), Space Complexity = O(1)
    public long kthElement(int k, int arr1[], int arr2[]) {
        
        int m = arr1.length;
        int n = arr2.length;
        
        if (m > n) {
            return kthElement(k, arr2, arr1);
        }

        int left = k; 
        
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);
        
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            
            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            
            if (mid1 < m) {
                r1 = arr1[mid1];
            }
            if (mid2 < n) {
                r2 = arr2[mid2];
            }
            
            if (mid1 - 1 >= 0) {
                l1 = arr1[mid1 - 1];
            }
            
            if (mid2 - 1 >= 0) {
                l2 = arr2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        
        return 0; 
    }
}
