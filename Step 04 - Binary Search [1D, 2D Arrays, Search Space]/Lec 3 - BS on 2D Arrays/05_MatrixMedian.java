// Question Link: https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix


class Solution {
    int upperBound(int[] arr, int x, int n) {
        int low = 0;
        int high = n - 1;
        
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
            
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        
        return ans;
    }

    int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        
        return cnt;
    }
    
    int median(int matrix[][], int R, int C) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            
            high = Math.max(high, matrix[i][C - 1]);
        }
        

        int req = (R * C) / 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            int smallEqual = countSmallEqual(matrix, R, C, mid);
            
            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}
